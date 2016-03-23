package com.grailsinaction

class LoginController {

    def form(String id) {
        [loginId: id]
    }

    def signIn(String loginId, String password) {
        def user = User.findByLoginId(loginId)
       // if (user && user.passwordHash == password) { se comenta porque ya tiene implementada la encriptacion de la pass
        if (user) {
            session.user = user
            redirect uri: "/"
        }
        else {
            flash.error = "Unknown username or password"
            redirect action: "form"
        }
    }
}