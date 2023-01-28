package com.il2c.spiget;

import com.il2c.spiget.api.builder.APIBuilder;
import com.il2c.spiget.web.WebBuilder;

public class SpigetAPI {

    private final WebBuilder webBuilder;

    private APIBuilder apiBuilder;

    public SpigetAPI() {
        this.webBuilder = new WebBuilder();
    }

    public WebBuilder getWebBuilder() {
        return webBuilder;
    }

    public APIBuilder getAPIBuilder() {
        if (apiBuilder == null) {
            apiBuilder = new APIBuilder(this);
        }

        return apiBuilder;
    }
}
