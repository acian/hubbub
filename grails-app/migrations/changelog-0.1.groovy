databaseChangeLog = {

	changeSet(author: "acian (generated)", id: "1459194966503-1") {
		createTable(tableName: "post") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "postPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "content", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-2") {
		createTable(tableName: "post_tags") {
			column(name: "tag_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "post_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-3") {
		createTable(tableName: "profile") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "profilePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "bio", type: "varchar(1000)")

			column(name: "country", type: "varchar(255)")

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "full_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "homepage", type: "varchar(255)")

			column(name: "jabber_address", type: "varchar(255)")

			column(name: "photo", type: "binary(2097152)")

			column(name: "skin", type: "varchar(9)")

			column(name: "timezone", type: "varchar(255)")

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-4") {
		createTable(tableName: "registration_code") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "registration_PK")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-5") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-6") {
		createTable(tableName: "tag") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tagPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-7") {
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "login_id", type: "varchar(20)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "password_hash", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-8") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-9") {
		createTable(tableName: "user_user") {
			column(name: "user_following_id", type: "bigint")

			column(name: "user_id", type: "bigint")
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-10") {
		addPrimaryKey(columnNames: "post_id, tag_id", tableName: "post_tags")
	}

	changeSet(author: "acian (generated)", id: "1459194966503-11") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "acian (generated)", id: "1459194966503-21") {
		createIndex(indexName: "user_id_uniq_1459194966446", tableName: "profile", unique: "true") {
			column(name: "user_id")
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-22") {
		createIndex(indexName: "authority_uniq_1459194966450", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-23") {
		createIndex(indexName: "login_id_uniq_1459194966453", tableName: "user", unique: "true") {
			column(name: "login_id")
		}
	}

	changeSet(author: "acian (generated)", id: "1459194966503-12") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "post", constraintName: "FK3498A03339FBA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1459194966503-13") {
		addForeignKeyConstraint(baseColumnNames: "post_id", baseTableName: "post_tags", constraintName: "FK7762B85824AB4F86", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "post", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1459194966503-14") {
		addForeignKeyConstraint(baseColumnNames: "tag_id", baseTableName: "post_tags", constraintName: "FK7762B8583081882E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tag", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1459194966503-15") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "profile", constraintName: "FKED8E89A93339FBA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1459194966503-16") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "tag", constraintName: "FK1BF9A3339FBA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1459194966503-17") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46A8E0F37C6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1459194966503-18") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A3339FBA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1459194966503-19") {
		addForeignKeyConstraint(baseColumnNames: "user_following_id", baseTableName: "user_user", constraintName: "FK143D5FBF8FFB7714", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1459194966503-20") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_user", constraintName: "FK143D5FBF3339FBA6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}
}
