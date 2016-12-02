package com.investec.expd.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author gregf
 * 
 * This class is a custom deserialiser for Boolean values in Jackson
 * Without this class, Jackson can only serialise the strings "true"
 * and "false" to boolean.
 * 
 * To add this deserialiser simply add it as a module, using the
 * following code:
 * 
 * ObjectMapper mapper = new ObjectMapper();
 * SimpleModule module = new SimpleModule();
 * module.addDeserializer(Boolean.class, new BooleanDeserializer());
 * mapper.registerModule(module);
 * project = mapper.readValue(jsonString, <YourClass>.class);
 * 
 */
public class BooleanDeserializer extends JsonDeserializer<Boolean>{

	@Override
	public Boolean deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
        return parseBooleanPrimitive(jp, ctxt);
	}
	
	protected final boolean parseBooleanPrimitive(JsonParser jp,
			DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
		JsonToken t = jp.getCurrentToken();
		if (t == JsonToken.VALUE_TRUE) {
			return true;
		}
		if (t == JsonToken.VALUE_FALSE) {
			return false;
		}
		if (t == JsonToken.VALUE_NULL) {
			return false;
		}
		if (t == JsonToken.VALUE_NUMBER_INT) {
			return (jp.getIntValue() != 0);
		}
		if (t == JsonToken.VALUE_STRING) {
			String text = jp.getText().trim();
			if ("true".equals(text)) {
				return true;
			}
			if ("false".equals(text) || text.length() == 0) {
				return Boolean.FALSE;
			}
			if ("n".equals(text) || text.length() == 0) {
				return Boolean.FALSE;
			} 
			if ("y".equals(text)) {
				return Boolean.TRUE;
			}
			if ("0".equals(text)) {
				return Boolean.FALSE;
			}	
			if ("1".equals(text)) {
				return Boolean.TRUE;
			}
			throw ctxt.weirdStringException(text,Boolean.class,
					"only true or false recognized");
		}
		// Otherwise, no can do:
		throw ctxt.mappingException(Boolean.class);
	}
}
