package com.grailsinaction

class PostController {
    static scaffold = true

    def postService
    def springSecurityService

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

}