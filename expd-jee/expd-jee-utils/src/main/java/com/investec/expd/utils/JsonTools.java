package com.investec.expd.utils;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author gregf
 *
 */
public class JsonTools {

	final static Logger logger = Logger.getLogger(JsonTools.class);

	public static void logJsonArray(JSONArray jsonArray) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JSONObject jsonObject;
			
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				jsonObject = iterator.next();
				Object json;
				json = mapper.readValue(jsonObject.toString(), Object.class);
				logger.debug(mapper.writerWithDefaultPrettyPrinter()
						.writeValueAsString(json));
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JsonNode marshalStringToJsonNode(String jsonString)
			throws JsonParseException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(jsonString);

		return actualObj;
	}
}
