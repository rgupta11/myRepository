package com.teradata.kafka.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.teradata.kafka.App;

public class TeradataDBConnector implements Connector {

	private Connection con;
	private String tableName = "alice.test_ravi";
	private String url = "jdbc:teradata://tddb.vantage-ss10.tdap.demos.teradatacloud.io";
	private String userName = "alice";
	private String password = "alice";
	private String topicName = App.topicName;
	List<ConsumerRecord<String, GenericRecord>> recordsList = new ArrayList<>(App.batchSize);
	private long start = 0;
	private long end = 0;
	private int batchCounter = 0;

	public Connection getConnection() throws Exception {

		try {
			if (null == con || con.isClosed()) {
				Class.forName("com.teradata.jdbc.TeraDriver");
				con = DriverManager.getConnection(url, userName, password);
				System.out.println("Connection created");
			}
		} catch (Exception e) {
			System.out.println("Error creating Connection");
			e.printStackTrace();
			throw e;
		}
		return con;
	}

	/* Utility DB methods */
	public void cleanTable() {

		String sql = " DELETE FROM " + tableName;
		try {
			Statement stmt = getConnection().createStatement();
			stmt.executeQuery(sql);
			
			System.out.println("cleanTable done");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in reading table " + tableName);
		}

	}
	
	
	public void readFromDB() {

		String sSelAll = " SELECT * FROM " + tableName + " ORDER BY recordId";
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(sSelAll);
			System.out.println("****************************");
			while (rset.next()) {
				System.out.println(rset.getInt(1) + "::" + rset.getString(2));
			}
			System.out.println("****************************");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in reading table " + tableName);
		}

	}
	
	
	public long getRecordCount() {

		String sSelAll = " SELECT count(*) FROM " + tableName;
		long count = 0;
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(sSelAll);
			System.out.println("***************************************************");
			while (rset.next()) {
				count = rset.getInt(1);
				System.out.println("No of records in " + tableName + "::" +  count);
			}
			System.out.println("***************************************************");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in reading table " + tableName);
		}
		return count;
	}

	public void addToDB(ConsumerRecord<String, GenericRecord> record) throws Exception {

		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		try {
			String insert = "INSERT INTO " + tableName + "(recordId, data) VALUES(" + record.offset() + ",'"
					+ record.value() + "')";
			System.out.println(insert);
			stmt.executeQuery(insert);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error writing to db");
			throw e;
		} finally {
			stmt.close();
			// connection.close();
		}

	}
	
	public void batchInsert(ConsumerRecord<String, GenericRecord> record) throws Exception {
		/*if(record.value().toString().contains("first")) {
			start = System.currentTimeMillis();
			batchCounter = 0;
			System.out.println("*************start********************");
		}*/
		
		recordsList.add(record);
		if(recordsList.size() < App.batchSize) {
			return;
		}
		Connection connection = getConnection();
		String insertSql = "INSERT into " + tableName + "(recordId, data) values(?, ?)" ;
		PreparedStatement pstmt = connection.prepareStatement(insertSql);
		try {
			for (ConsumerRecord<String, GenericRecord> rec : recordsList) {
				pstmt.setLong(1, rec.offset());
				pstmt.setString(2, rec.value().toString());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			System.out.println("writing....");
			/*if(record.value().toString().contains("last")) {
				long end = System.currentTimeMillis();
				System.out.println(end);
				long seconds = TimeUnit.MILLISECONDS.toSeconds(end - start);
				System.out.println("Tme elapsed seconds: " + seconds);
				System.out.println("**************end*******************");
			}
			batchCounter++;*/
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error writing to db");
			throw e;
		} finally {
			pstmt.close();
			// connection.close();
		}
		recordsList.clear();
	}

}
