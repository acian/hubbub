package com.grailsinaction

class PostController {
    static scaffold = true

    def postService
    def springSecurityService

    static navigation = [
            [group:'tabs', action: 'personal', title: 'My Timeline', order: 0],
            [action: 'global', title: 'Global Timeline', order: 1]
    ]

    def timeline() {
        def user = User.findByLoginId(params.id)
        if (!user) {
            response.sendError(404)
        } else {
            [ user : user ]
        }
    }

    def personal() {
        if (!session.user) {
            redirect controller: "login", action: "form"
            return
        } else {
            // Need to reattach the user domain object to the session using
            // the refresh() method.
            render view: "timeline", model: [ user : session.user.refresh() ]
        }
    }


    def addPost(String id, String content){

        def user = springSecurityService.currentUser

        if (user) {

            try {
                def newPost = postService.createPost(id, content)
                flash.message = "Added new post: ${newPost.content}"
            } catch (PostException pe) {
                flash.message = pe.message
            }

        } else {

            flash.message = "Invalid User Id"
        }
        redirect(action: 'timeline', id: id)

    }

    def global() {
        [ posts : Post.list(params), postCount : Post.count() ]
    }

    def addPostAjax(String content) {
        try {
            def newPost = postService.createPost(session.user.loginId, content)
            def recentPosts = Post.findAllByUser(
                    session.user,
                    [sort: 'dateCreated', order: 'desc', max: 20])
            render template: 'postEntry', collection: recentPosts, var: 'post'
        } catch (PostException pe) {
            render {
                div(class:"errors", pe.message)
            }
        }
    }

    def tinyUrl(String fullUrl) {
        def origUrl = fullUrl?.encodeAsURL()
        def tinyUrl =
                new URL("http://tinyurl.com/api-create.php?url=${origUrl}").text
        render(contentType:"application/json") {
            urls(small: tinyUrl, full:fullUrl)
        }
    }


}
