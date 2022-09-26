package it.itfinance.challenge.serializer;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

//Serializza la proprietà timestamp come stringa per evitare conflitto in Gson 
public class OffsetDateTimeSerializer implements JsonSerializer<OffsetDateTime> {

	@Override
	public JsonElement serialize(OffsetDateTime arg0, Type arg1, JsonSerializationContext arg2) {

		return arg2.serialize(arg0.toString());
	}


}
