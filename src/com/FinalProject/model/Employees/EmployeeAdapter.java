package com.FinalProject.model.Employees;

import com.google.gson.*;

import java.lang.reflect.Type;

public class EmployeeAdapter implements JsonSerializer<Employee>, JsonDeserializer<Employee> {
    @Override
    public JsonElement serialize(Employee src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        result.add("properties", context.serialize(src, src.getClass()));//to keep fields of the object in json
        return result;
    }

    @Override
    public Employee deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            return context.deserialize(element, Class.forName("com.FinalProject.model.Employees." + type)); //deserialiaze according to User type.
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }
    }
}
