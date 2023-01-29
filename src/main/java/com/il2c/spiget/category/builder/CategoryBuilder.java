package com.il2c.spiget.category.builder;

import com.google.gson.JsonElement;
import com.il2c.spiget.SpigetAPI;
import com.il2c.spiget.category.response.Category;
import com.il2c.spiget.global.SortOrder;
import com.il2c.spiget.resource.response.Resource;
import com.il2c.spiget.web.builder.WebBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryBuilder {

    private final WebBuilder webBuilder;

    public CategoryBuilder(SpigetAPI api) {
        this.webBuilder = api.getWebBuilder();
    }

    public Optional<List<Category>> getCategories() {
        return getCategories(0, 0, null);
    }

    public Optional<List<Category>> getCategories(SortOrder sort) {
        return getCategories(0, 0, sort);
    }

    public Optional<List<Category>> getCategories(String... fields) {
        return getCategories(0, 0, null, fields);
    }

    public Optional<List<Category>> getCategories(int size, int page) {
        return getCategories(size, page, null);
    }

    public Optional<List<Category>> getCategories(SortOrder sort, String... fields) {
        return getCategories(0, 0, sort, fields);
    }

    public Optional<List<Category>> getCategories(int size, int page, SortOrder sort, String... fields) {
        String parameters = (size == 0 ? "" : "size=" + size);
        parameters += (page == 0 ? "" : (parameters.isEmpty() ? "" : "&") + "page=" + page);
        parameters += (sort == null ? "" : (parameters.isEmpty() ? "" : "&") + "sort=" + sort.getCode());
        parameters += (fields == null || fields.length == 0 ? "" :
                       (parameters.isEmpty() ? "" : "&") + "fields=" +
                       URLEncoder.encode(String.join(",", fields), StandardCharsets.UTF_8));
        parameters = parameters.isEmpty() ? "" : "?" + parameters;

        JsonElement jsonElement = webBuilder.getResponse("categories" + parameters).orElse(null);

        if (jsonElement == null) {
            return Optional.empty();
        }

        List<Category> categoriesList = new ArrayList<>();

        jsonElement.getAsJsonArray().asList().forEach(
                category -> categoriesList.add(webBuilder.getGson().fromJson(category, Category.class)));

        return Optional.of(categoriesList);
    }

    public Optional<Category> getCategory(int id) {
        return webBuilder.getResponse("categories/" + id)
                         .map(jsonElement -> webBuilder.getGson().fromJson(jsonElement, Category.class));
    }

    public Optional<List<Resource>> getCategoryResources(int id) {
        return getCategoryResources(id, 0, 0, null);
    }

    public Optional<List<Resource>> getCategoryResources(int id, SortOrder sort) {
        return getCategoryResources(id, 0, 0, sort);
    }

    public Optional<List<Resource>> getCategoryResources(int id, String... fields) {
        return getCategoryResources(id, 0, 0, null, fields);
    }

    public Optional<List<Resource>> getCategoryResources(int id, int size, int page) {
        return getCategoryResources(id, size, page, null);
    }

    public Optional<List<Resource>> getCategoryResources(int id, SortOrder sort, String... fields) {
        return getCategoryResources(id, 0, 0, sort, fields);
    }

    public Optional<List<Resource>> getCategoryResources(int id, int size, int page, SortOrder sort,
                                                         String... fields) {
        String parameters = (size == 0 ? "" : "size=" + size);
        parameters += (page == 0 ? "" : (parameters.isEmpty() ? "" : "&") + "page=" + page);
        parameters += (sort == null ? "" : (parameters.isEmpty() ? "" : "&") + "sort=" + sort.getCode());
        parameters += (fields == null || fields.length == 0 ? "" :
                       (parameters.isEmpty() ? "" : "&") + "fields=" +
                       URLEncoder.encode(String.join(",", fields), StandardCharsets.UTF_8));
        parameters = parameters.isEmpty() ? "" : "?" + parameters;

        JsonElement jsonElement =
                webBuilder.getResponse("categories/" + id + "/resources" + parameters).orElse(null);

        if (jsonElement == null) {
            return Optional.empty();
        }

        List<Resource> resourcesList = new ArrayList<>();

        jsonElement.getAsJsonArray().asList().forEach(
                resource -> resourcesList.add(webBuilder.getGson().fromJson(resource, Resource.class)));

        return Optional.of(resourcesList);
    }
}
