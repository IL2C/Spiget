package com.il2c.spiget.web;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Optional;

public class WebBuilder {

    private final Gson gson;

    private String userAgent;

    public WebBuilder() {
        gson = new Gson();
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public Optional<JsonElement> getResponse(String endpoint) {
        try {
            Connection connection =
                    Jsoup.connect("https://api.spiget.org/v2/" + endpoint).method(Connection.Method.GET)
                         .ignoreHttpErrors(true).ignoreContentType(true);

            if (userAgent != null) {
                connection.userAgent(userAgent);
            }

            Connection.Response response = connection.execute();

            if (response.statusCode() == 200) {
                return Optional.of(JsonParser.parseString(response.body()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public Gson getGson() {
        return gson;
    }
}
