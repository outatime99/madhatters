package com.investec.expd.utils;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.investec.expd.model.Widget;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author gregf
 *
 * This factory class will be used to serialise and deserialise 
 * widget objects from JSON.
 */
public class WidgetJsonUtils {

	final static Logger logger = Logger.getLogger(WidgetJsonUtils.class);
	
	public Widget createWidgettObjectFromJsonObject(JSONObject jsonObject) {
		logger.debug("Create widget object from org.json.simple.JSONObject");
		logger.debug("Supplied JSON Object: " + jsonObject.toString());
		Widget widget = this.createWidgetObjectFromJsonString(jsonObject.toString());

		return widget;
	}	
	
	public Widget createWidgetObjectFromJsonString(String jsonString) {
		logger.debug("Create widget object from String");
		Widget widget = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			SimpleModule module = new SimpleModule();
			module.addDeserializer(Boolean.class, new BooleanDeserializer());
			mapper.registerModule(module);
			logger.debug("Supplied JSON String: " + jsonString);
			widget = mapper.readValue(jsonString, Widget.class);
			logger.debug(mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(widget));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return widget;
	}
}
