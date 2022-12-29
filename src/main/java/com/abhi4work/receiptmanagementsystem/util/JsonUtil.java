package com.abhi4work.receiptmanagementsystem.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    public JsonUtil()
    {
    }
    public static String toJson(Object object, Class clazz)
    {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        return gson.toJson(object, clazz);
    }
    public static <T> T fromJson(String data, Class<T> clazz)
    {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return gson.fromJson(data, clazz);
    }
    public static boolean isJSONValid(String jsonInString)
    {
        try
        {
            Gson gson = new Gson();
            gson.fromJson(jsonInString, Object.class);
            return true;
        }
        catch (JsonSyntaxException ex)
        {
            return false;
        }
    }
    public static <T> List<T> fromJsonStringToPojoList(String reasons)
    {
        if (reasons == null || reasons.equals("null"))
        {
            return null;
        }
        Gson gson = new Gson();
        Type listOfReasons = new TypeToken<ArrayList<T>>()
        {
        }.getType();
        List<T> reasonsAsPojo = gson.fromJson(reasons, listOfReasons);
        return reasonsAsPojo;
    }
    public static String toJsonWithNulls(Object object, Class clazz)
    {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(object, clazz);
    }
    public static <T> String toJson(List<T> objectList)
    {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        return gson.toJson(objectList);
    }
}
