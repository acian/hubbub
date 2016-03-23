databaseChangeLog = {

	changeSet(author: "acian (generated)", id: "1458581044593-1") {
		createTable(tableName: "POST") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_2")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "CONTENT", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "DATE_CREATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}

			column(name: "USER_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1458581044593-2") {
		createTable(tableName: "POST_TAGS") {
			column(name: "POST_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "TAG_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1458581044593-3") {
		createTable(tableName: "PROFILE") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_18")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "BIO", type: "VARCHAR(1000)")

			column(name: "COUNTRY", type: "VARCHAR(255)")

			column(name: "EMAIL", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "FULL_NAME", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "HOMEPAGE", type: "VARCHAR(255)")

			column(name: "JABBER_ADDRESS", type: "VARCHAR(255)")

			column(name: "PHOTO", type: "VARBINARY(2097152)")

			column(name: "TIMEZONE", type: "VARCHAR(255)")

			column(name: "USER_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1458581044593-4") {
		createTable(tableName: "REGISTRATION_CODE") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_A")
			}

			column(name: "DATE_CREATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}

			column(name: "TOKEN", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "USERNAME", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1458581044593-5") {
		createTable(tableName: "ROLE") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_26")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "AUTHORITY", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1458581044593-6") {
		createTable(tableName: "TAG") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_14")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "NAME", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "USER_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1458581044593-7") {
		createTable(tableName: "USER") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_27")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "ACCOUNT_EXPIRED", type: "BOOLEAN") {
				constraints(nullable: "false")
			}

			column(name: "ACCOUNT_LOCKED", type: "BOOLEAN") {
				constraints(nullable: "false")
			}

			column(name: "DATE_CREATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}

			column(name: "ENABLED", type: "BOOLEAN") {
				constraints(nullable: "false")
			}

			column(name: "LOGIN_ID", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "PASSWORD_EXPIRED", type: "BOOLEAN") {
				constraints(nullable: "false")
			}

			column(name: "PASSWORD_HASH", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1458581044593-8") {
		createTable(tableName: "USER_ROLE") {
			column(name: "ROLE_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "USER_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "acian (generated)", id: "1458581044593-9") {
		createTable(tableName: "USER_USER") {
			column(name: "USER_FOLLOWING_ID", type: "BIGINT")

			column(name: "USER_ID", type: "BIGINT")
		}
	}

	changeSet(author: "acian (generated)", id: "1458581044593-10") {
		addPrimaryKey(columnNames: "POST_ID, TAG_ID", constraintName: "CONSTRAINT_1", tableName: "POST_TAGS")
	}

	changeSet(author: "acian (generated)", id: "1458581044593-11") {
		addPrimaryKey(columnNames: "ROLE_ID, USER_ID", constraintName: "CONSTRAINT_B", tableName: "USER_ROLE")
	}

	changeSet(author: "acian (generated)", id: "1458581044593-21") {
		createIndex(indexName: "CONSTRAINT_INDEX_2", tableName: "ROLE", unique: "true") {
			column(name: "AUTHORITY")
		}
	}

	changeSet(author: "acian (generated)", id: "1458581044593-22") {
		createIndex(indexName: "CONSTRAINT_INDEX_27", tableName: "USER", unique: "true") {
			column(name: "LOGIN_ID")
		}
	}

	changeSet(author: "acian (generated)", id: "1458581044593-12") {
		addForeignKeyConstraint(baseColumnNames: "USER_ID", baseTableName: "POST", baseTableSchemaName: "PUBLIC", constraintName: "FK3498A03339FBA6", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "USER", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1458581044593-13") {
		addForeignKeyConstraint(baseColumnNames: "POST_ID", baseTableName: "POST_TAGS", baseTableSchemaName: "PUBLIC", constraintName: "FK7762B85824AB4F86", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "POST", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1458581044593-14") {
		addForeignKeyConstraint(baseColumnNames: "TAG_ID", baseTableName: "POST_TAGS", baseTableSchemaName: "PUBLIC", constraintName: "FK7762B8583081882E", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "TAG", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1458581044593-15") {
		addForeignKeyConstraint(baseColumnNames: "USER_ID", baseTableName: "PROFILE", baseTableSchemaName: "PUBLIC", constraintName: "FKED8E89A93339FBA6", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "USER", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1458581044593-16") {
		addForeignKeyConstraint(baseColumnNames: "USER_ID", baseTableName: "TAG", baseTableSchemaName: "PUBLIC", constraintName: "FK1BF9A3339FBA6", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "USER", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1458581044593-17") {
		addForeignKeyConstraint(baseColumnNames: "ROLE_ID", baseTableName: "USER_ROLE", baseTableSchemaName: "PUBLIC", constraintName: "FK143BF46A8E0F37C6", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "ROLE", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1458581044593-18") {
		addForeignKeyConstraint(baseColumnNames: "USER_ID", baseTableName: "USER_ROLE", baseTableSchemaName: "PUBLIC", constraintName: "FK143BF46A3339FBA6", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "USER", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1458581044593-19") {
		addForeignKeyConstraint(baseColumnNames: "USER_FOLLOWING_ID", baseTableName: "USER_USER", baseTableSchemaName: "PUBLIC", constraintName: "FK143D5FBF8FFB7714", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "USER", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	changeSet(author: "acian (generated)", id: "1458581044593-20") {
		addForeignKeyConstraint(baseColumnNames: "USER_ID", baseTableName: "USER_USER", baseTableSchemaName: "PUBLIC", constraintName: "FK143D5FBF3339FBA6", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "USER", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}
}
