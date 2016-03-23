package com.grailsinaction

class User {

	transient springSecurityService

	String loginId
	String passwordHash
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	Date dateCreated

	static hasOne = [ profile : Profile ]
	static hasMany = [ posts : Post, tags : Tag, following : User ]

	static transients = ['springSecurityService']

	static constraints = {
			loginId size: 3..20, unique: true, blank: false
			tags()
			posts()
			profile nullable: true
	}

	static mapping = {
		posts sort: "dateCreated", order: "desc"
	}

	static searchable = {
		except = ["passwordHash"]
	}
	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	String toString() { return "User $loginId (id: $id)" }
	String getDisplayString() { return loginId }

	protected void encodePassword() {
		passwordHash = springSecurityService.encodePassword(passwordHash)
	}
}
