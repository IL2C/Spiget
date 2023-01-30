package com.il2c.spiget.response.builder;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.il2c.spiget.SpigetAPI;
import com.il2c.spiget.response.parameter.Parameter;
import com.il2c.spiget.web.builder.WebBuilder;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResponseBuilder {

    private final WebBuilder webBuilder;
    private final Gson gson;

    public ResponseBuilder(SpigetAPI api) {
        webBuilder = api.getWebBuilder();
        gson = new Gson();
    }

    public BufferedInputStream getResponseForDownload(String endpoint) {
        Connection.Response response = getConnectionResponse(endpoint, 0);

        return response != null ? response.bodyStream() : null;
    }

    public Object getResponseWithoutParameters(String endpoint, Class<?> clazz) {
        return getResponseWithoutParameters(endpoint, clazz, null);
    }

    public Object getResponseWithoutParameters(String endpoint, Class<?> clazz, String memberName) {
        JsonElement jsonElement = getJsonElement(endpoint);

        return jsonElement != null ? getObjectFromJson(
                memberName != null ? jsonElement.getAsJsonObject().get(memberName) : jsonElement, clazz) :
               null;
    }

    public Object getResponseWithParametersAsObject(String endpoint, Class<?> clazz,
                                                    Parameter... parameters) {
        JsonElement jsonElement = getResponseWithParameters(endpoint, parameters);

        return jsonElement != null ? gson.fromJson(jsonElement, clazz) : null;
    }

    public List<Object> getResponseWithParametersAsList(String endpoint, Class<?> clazz,
                                                        Parameter... parameters) {
        JsonElement jsonElement = getResponseWithParameters(endpoint, parameters);

        if (jsonElement == null) {
            return null;
        }

        List<Object> list = new ArrayList<>();
        jsonElement.getAsJsonArray().asList().forEach(object -> list.add(gson.fromJson(object, clazz)));

        return list;
    }

    private JsonElement getResponseWithParameters(String endpoint, Parameter... parameters) {
        StringBuilder parametersRaw = new StringBuilder("?");

        if (parameters != null) {
            for (Parameter parameter : parameters) {
                Object value = parameter.getValue();

                if (value == null || (value instanceof Integer && (int) value == 0) ||
                    (value instanceof Object[] && ((Object[]) value).length == 0)) {
                    continue;
                }

                parametersRaw.append(parametersRaw.length() != 1 ? "&" : "")
                             .append(parameter.getKey())
                             .append("=")
                             .append(value);
            }
        }

        return getJsonElement(endpoint + (parametersRaw.length() != 1 ? parametersRaw.toString() : ""));
    }

    private JsonElement getJsonElement(String endpoint) {
        Connection.Response response = getConnectionResponse(endpoint, 200);

        return response != null ? JsonParser.parseString(response.body()) : null;
    }

    private Connection.Response getConnectionResponse(String endpoint, int statusCode) {
        try {
            Connection connection = Jsoup.connect("https://api.spiget.org/v2/" + endpoint)
                                         .method(Connection.Method.GET)
                                         .ignoreHttpErrors(true)
                                         .ignoreContentType(true);

            String userAgent = webBuilder.getUserAgent();

            if (userAgent != null) {
                connection.userAgent(userAgent);
            }

            Connection.Response response = connection.execute();

            return response.statusCode() == statusCode ? response : null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Object getObjectFromJson(JsonElement jsonElement, Class<?> clazz) {
        return gson.fromJson(jsonElement, clazz);
    }
}
