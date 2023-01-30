package com.il2c.spiget.api.builder;

import com.il2c.spiget.api.reponse.Stats;
import com.il2c.spiget.api.reponse.Status;
import com.il2c.spiget.response.builder.ResponseBuilder;

import java.util.Optional;

public class APIBuilder {

    private final ResponseBuilder responseBuilder;

    public APIBuilder(ResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    public Optional<Status> getStatus() {
        return Optional.ofNullable(
                (Status) responseBuilder.getResponseWithoutParameters("status", Status.class, "status"));
    }

    public Optional<Stats> getStats() {
        return Optional.ofNullable(
                (Stats) responseBuilder.getResponseWithoutParameters("status", Stats.class, "stats"));
    }
}
