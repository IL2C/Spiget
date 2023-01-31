package com.il2c.spiget;

import com.il2c.spiget.api.builder.APIBuilder;
import com.il2c.spiget.author.builder.AuthorBuilder;
import com.il2c.spiget.category.builder.CategoryBuilder;
import com.il2c.spiget.resource.builder.ResourceBuilder;
import com.il2c.spiget.response.builder.ResponseBuilder;
import com.il2c.spiget.search.builder.SearchBuilder;
import com.il2c.spiget.web.builder.WebBuilder;

public class Spiget {

    private final ResponseBuilder responseBuilder;

    private WebBuilder webBuilder;
    private APIBuilder apiBuilder;
    private AuthorBuilder authorBuilder;
    private CategoryBuilder categoryBuilder;
    private ResourceBuilder resourceBuilder;
    private SearchBuilder searchBuilder;

    public Spiget() {
        this.responseBuilder = new ResponseBuilder(this);
    }

    public WebBuilder getWebBuilder() {
        if (webBuilder == null) {
            webBuilder = new WebBuilder();
        }

        return webBuilder;
    }

    public APIBuilder getAPIBuilder() {
        if (apiBuilder == null) {
            apiBuilder = new APIBuilder(responseBuilder);
        }

        return apiBuilder;
    }

    public AuthorBuilder getAuthorBuilder() {
        if (authorBuilder == null) {
            authorBuilder = new AuthorBuilder(responseBuilder);
        }

        return authorBuilder;
    }

    public CategoryBuilder getCategoryBuilder() {
        if (categoryBuilder == null) {
            categoryBuilder = new CategoryBuilder(responseBuilder);
        }

        return categoryBuilder;
    }

    public ResourceBuilder getResourceBuilder() {
        if (resourceBuilder == null) {
            resourceBuilder = new ResourceBuilder(responseBuilder);
        }

        return resourceBuilder;
    }

    public SearchBuilder getSearchBuilder() {
        if (searchBuilder == null) {
            searchBuilder = new SearchBuilder(responseBuilder);
        }

        return searchBuilder;
    }
}
