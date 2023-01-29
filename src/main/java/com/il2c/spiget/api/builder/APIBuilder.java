package com.il2c.spiget.api.builder;

import com.il2c.spiget.SpigetAPI;
import com.il2c.spiget.api.reponse.Stats;
import com.il2c.spiget.api.reponse.Status;
import com.il2c.spiget.web.builder.WebBuilder;

import java.util.Optional;

public class APIBuilder {

    private final WebBuilder webBuilder;

    public APIBuilder(SpigetAPI api) {
        this.webBuilder = api.getWebBuilder();
    }

    public Optional<Status> getStatus() {
        return webBuilder.getResponse("status").map(jsonElement -> webBuilder.getGson().fromJson(
                jsonElement.getAsJsonObject().get("status"), Status.class));
    }

    public Optional<Stats> getStats() {
        return webBuilder.getResponse("status").map(jsonElement -> webBuilder.getGson().fromJson(
                jsonElement.getAsJsonObject().get("stats"), Stats.class));
    }
}
