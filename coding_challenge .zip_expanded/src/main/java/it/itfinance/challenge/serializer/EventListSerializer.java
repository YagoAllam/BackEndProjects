package it.itfinance.challenge.serializer;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import it.itfinance.challenge.models.EventlogGroup;

//Serializza la proprietà variante come array invece che oggetto eventList con array intero
public class EventListSerializer implements JsonSerializer<EventlogGroup> {

	@Override
	public JsonElement serialize(EventlogGroup arg0, Type arg1, JsonSerializationContext arg2) {
		return arg2.serialize(arg0.getList());

	}

}
