package com.il2c.spiget;

import com.il2c.spiget.api.builder.APIBuilder;
import com.il2c.spiget.author.builder.AuthorBuilder;
import com.il2c.spiget.web.builder.WebBuilder;

public class SpigetAPI {

    private final WebBuilder webBuilder;

    private APIBuilder apiBuilder;
    private AuthorBuilder authorBuilder;

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

    public AuthorBuilder getAuthorBuilder() {
        if (authorBuilder == null) {
            authorBuilder = new AuthorBuilder(this);
        }

        return authorBuilder;
    }
}
