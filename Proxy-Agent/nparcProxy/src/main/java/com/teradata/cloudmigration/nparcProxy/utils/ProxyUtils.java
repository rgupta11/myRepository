package com.teradata.cloudmigration.nparcProxy.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.http.ParseException;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ProxyUtils.class);
	
	public static String decodeBase64(String encodedStr) {
		logger.debug("encodedStr:" + encodedStr);
		String decoded = new String(Base64.getDecoder().decode(encodedStr));
		logger.debug("decodedStr:" + decoded);
		return decoded;
	}
	
	/**
	 * The string must be in JSON format
	 * @param str
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws JSONException 
	 */
	public static JSONObject getJson(String str) throws ParseException, IOException, JSONException {

		logger.debug("Received String to Jsonify: " + str);
		StringEntity entity = new StringEntity(str, ContentType.APPLICATION_JSON);
		String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
		return new JSONObject(json);
		
	}

}
