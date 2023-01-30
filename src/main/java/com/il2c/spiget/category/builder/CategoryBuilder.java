package com.il2c.spiget.category.builder;

import com.il2c.spiget.category.response.Category;
import com.il2c.spiget.global.SortOrder;
import com.il2c.spiget.resource.response.Resource;
import com.il2c.spiget.response.builder.ResponseBuilder;
import com.il2c.spiget.response.parameter.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryBuilder {

    private final ResponseBuilder responseBuilder;

    public CategoryBuilder(ResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
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
        List<Object> responseList =
                responseBuilder.getResponseWithParametersAsList("categories", Category.class,
                        new Parameter("size", size), new Parameter("page", page),
                        new Parameter("sort", sort != null ? sort.getCode() : null),
                        new Parameter("fields", fields != null ? String.join(",", fields) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Category> categoriesList = new ArrayList<>();
        responseList.forEach(object -> categoriesList.add((Category) object));

        return Optional.of(categoriesList);
    }

    public Optional<Category> getCategory(int id) {
        return Optional.ofNullable(
                (Category) responseBuilder.getResponseWithoutParameters("categories/" + id, Category.class));
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
        List<Object> responseList =
                responseBuilder.getResponseWithParametersAsList("categories/" + id + "/resources",
                        Resource.class, new Parameter("size", size), new Parameter("page", page),
                        new Parameter("sort", sort != null ? sort.getCode() : null),
                        new Parameter("fields", fields != null ? String.join(",", fields) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Resource> resourcesList = new ArrayList<>();
        responseList.forEach(object -> resourcesList.add((Resource) object));

        return Optional.of(resourcesList);
    }
}
