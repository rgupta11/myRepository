package com.teradata.kafka.connector;

import java.sql.Connection;

public interface Connector {
	
	public Connection getConnection() throws Exception;

}
