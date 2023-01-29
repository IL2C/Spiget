package com.il2c.spiget;

import com.il2c.spiget.api.builder.APIBuilder;
import com.il2c.spiget.author.builder.AuthorBuilder;
import com.il2c.spiget.category.builder.CategoryBuilder;
import com.il2c.spiget.resource.builder.ResourceBuilder;
import com.il2c.spiget.search.builder.SearchBuilder;
import com.il2c.spiget.web.builder.WebBuilder;

public class SpigetAPI {

    private final WebBuilder webBuilder;

    private APIBuilder apiBuilder;
    private AuthorBuilder authorBuilder;
    private CategoryBuilder categoryBuilder;
    private ResourceBuilder resourceBuilder;
    private SearchBuilder searchBuilder;

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

    public CategoryBuilder getCategoryBuilder() {
        if (categoryBuilder == null) {
            categoryBuilder = new CategoryBuilder(this);
        }

        return categoryBuilder;
    }

    public ResourceBuilder getResourceBuilder() {
        if (resourceBuilder == null) {
            resourceBuilder = new ResourceBuilder(this);
        }

        return resourceBuilder;
    }

    public SearchBuilder getSearchBuilder() {
        if (searchBuilder == null) {
            searchBuilder = new SearchBuilder(this);
        }

        return searchBuilder;
    }
}
