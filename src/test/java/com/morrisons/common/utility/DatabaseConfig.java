package com.morrisons.common.utility;

public class DatabaseConfig {

	public String databaseHostname;
	public String databaseUsername;
	public String databasePassword;
	
	public String getDatabaseHostname() {
		return databaseHostname;
	}
	public void setDatabaseHostname(String databaseHostname) {
		this.databaseHostname = databaseHostname;
	}
	public String getDatabaseUsername() {
		return databaseUsername;
	}
	public void setDatabaseUsername(String databaseUsername) {
		this.databaseUsername = databaseUsername;
	}
	public String getDatabasePassword() {
		return databasePassword;
	}
	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}
	@Override
	public String toString() {
		return "DatabaseConfig [databaseHostname=" + databaseHostname + ", databaseUsername=" + databaseUsername
				+ ", databasePassword=" + databasePassword + "]";
	}
}
