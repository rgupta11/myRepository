package com.teradata.cloudmigration.nparcProxy.data;

import java.io.Serializable;
import java.util.Map;

public class HttpResponseData implements Serializable {
	
	private int statusCode;
	private String message;
	private Map<String, String> body;
	private String migrationId;
	private Map<String, String> headers;
	 

	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public String getMigrationId() {
		return migrationId;
	}
	public void setMigrationId(String migrationId) {
		this.migrationId = migrationId;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, String> getBody() {
		return body;
	}
	public void setBody(Map<String, String> body) {
		this.body = body;
	}

}
