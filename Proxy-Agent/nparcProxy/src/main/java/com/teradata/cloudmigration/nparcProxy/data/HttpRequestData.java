package com.teradata.cloudmigration.nparcProxy.data;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
//@Service
//@Scope(value="prototype")
public class HttpRequestData implements Serializable {
	
	@Value("${migration.source.ip}")
    private String sourceIP;
	
	@Value("${migration.target.ip}")
    private String targetIP;
	
	@Value("${migration.source.identifier}")
    private String sourceIdentifier;
	
	@Value("${migration.target.identifier}")
    private String targetIdentifier;
	
	private String methodName;
	private String hostName;
	private int port;
	private String requestUrl;
	private Map<String, String> headers;
	private String queryString;
	private String payLoad;
	private String migrationId;
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		
		requestUrl = manageURL(requestUrl);
		this.requestUrl = requestUrl;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public String getPayLoad() {
		return payLoad;
	}
	public void setPayLoad(String payLoad) {
		this.payLoad = payLoad;
	}
	
	public String getSourceIP() {
		return sourceIP;
	}

	public void setSourceIP(String sourceIP) {
		this.sourceIP = sourceIP;
	}

	public String getTargetIP() {
		return targetIP;
	}

	public void setTargetIP(String targetIP) {
		this.targetIP = targetIP;
	}

	public String getSourceIdentifier() {
		return sourceIdentifier;
	}

	public void setSourceIdentifier(String sourceIdentifier) {
		this.sourceIdentifier = sourceIdentifier;
	}

	public String getTargetIdentifier() {
		return targetIdentifier;
	}

	public void setTargetIdentifier(String targetIdentifier) {
		this.targetIdentifier = targetIdentifier;
	}

	public String getMigrationId() {
		return migrationId;
	}

	public void setMigrationId(String migrationId) {
		this.migrationId = migrationId;
	}
	
	public String toJson() throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println();
		return mapper.writeValueAsString(this);
		
	}

	private String manageURL(String requestUrl) {
		
		if(requestUrl.contains(sourceIdentifier)) {
			requestUrl = requestUrl.replace(sourceIdentifier, sourceIP);
		}else if(requestUrl.contains(targetIdentifier)) {
			requestUrl = requestUrl.replace(targetIdentifier, targetIP);
		}else {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		
		return requestUrl;
	}


}
