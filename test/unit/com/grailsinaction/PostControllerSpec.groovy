package com.grailsinaction

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PostController)
@Mock([User,Post])
class PostControllerSpec extends Specification {
    def "Get a users timeline given their id"() {
        given: "A user with posts in the db"
        User chuck = new User(
                loginId: "chuck_norris",
                password: "passwordHash")
        chuck.addToPosts(new Post(content: "A first post"))
        chuck.addToPosts(new Post(content: "A second post"))
        chuck.save(failOnError: true)
        and: "A loginId parameter"
        params.id = chuck.loginId

        when: "the timeline is invoked"
        def model = controller.timeline()

        then: "the user is in the returned model"
        model.user.loginId == "chuck_norris"
        model.user.posts.size() == 2

    }

    def "Check that non-existent users are handled with an error"() {
        given: "the id of a non-existent user"
        params.id = "this-user-id-does-not-exist"

        when: "the timeline is invoked"
        controller.timeline()
        then: "a 404 is sent to the browser"
        response.status == 404

    }

        def "Adding a valid new post to the timeline"() {
            given: "A user with posts in the db"
            User chuck = new User(
                    loginId: "chuck_norris",
                    password: "passwordHash").save(failOnError: true)
            and: "A loginId parameter"
            params.id = chuck.loginId

            and: "Some content for the post"
            params.content = "Chuck Norris can unit test entire assert."
            when: "addPost is invoked"
            def model = controller.addPost()
            then: "our flash message and redirect confirms the success"
            flash.message == "Successfully created Post"
            response.redirectedUrl == "/post/timeline/${chuck.loginId}"
            Post.countByUser(chuck) == 1

    }

    def "Adding an empty post"() {
        given: "A user with empty posts"
        User chuck = new User(
                loginId: "chuck_norris",
                password: "passwordHash").save(failOnError: true)
        and: "A loginId parameter"
        params.id = chuck.loginId

        and: "Empty post"
        params.content = ""

        when: "addPost is invoked"
        def model = controller.addPost()
        then: "our flash message inform error"
        flash.message == "Invalid or empty post"
        response.redirectedUrl == "/post/timeline/${chuck.loginId}"
        Post.countByUser(chuck) == 0

    }

    @spock.lang.Unroll
    def "Testing id of #suppliedId redirects to #expectedUrl"() {
        given:
        params.id = suppliedId
        when: "Controller is invoked"
        controller.index()
        then:
        response.redirectedUrl == expectedUrl
        where:
        suppliedId  |   expectedUrl
        'joe_cool'  |   '/post/timeline/joe_cool'
        null        |   '/post/timeline/chuck_norris'

    }

}