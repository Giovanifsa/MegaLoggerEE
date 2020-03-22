package com.kvkserver.megalogger.configuration.database.migration;

import com.jeeasy.engine.database.migration.EnumMigrationDatabase;
import com.jeeasy.engine.database.migration.IMigrationLocation;

public class MegaLoggerMySQLMigrationLocation implements IMigrationLocation {

	@Override
	public EnumMigrationDatabase getSupportedDatabase() {
		return EnumMigrationDatabase.MYSQL;
	}

	@Override
	public String getLocation() {
		return "sql/megalogger/mysql";
	}

}
