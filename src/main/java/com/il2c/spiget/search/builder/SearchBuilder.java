package com.il2c.spiget.search.builder;

import com.il2c.spiget.author.response.Author;
import com.il2c.spiget.global.parameter.Sort;
import com.il2c.spiget.resource.response.Resource;
import com.il2c.spiget.response.builder.ResponseBuilder;
import com.il2c.spiget.response.parameter.Parameter;
import com.il2c.spiget.search.parameter.SearchQueryField;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchBuilder {

    private final ResponseBuilder responseBuilder;

    public SearchBuilder(ResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    public Optional<List<Author>> getAuthors(String query) {
        return getAuthors(query, null, 0, 0, null);
    }

    public Optional<List<Author>> getAuthors(String query, SearchQueryField field) {
        return getAuthors(query, field, 0, 0, null);
    }

    public Optional<List<Author>> getAuthors(String query, Sort sort) {
        return getAuthors(query, null, 0, 0, sort);
    }

    public Optional<List<Author>> getAuthors(String query, String... fields) {
        return getAuthors(query, null, 0, 0, null, fields);
    }

    public Optional<List<Author>> getAuthors(String query, int size, int page) {
        return getAuthors(query, null, size, page, null);
    }

    public Optional<List<Author>> getAuthors(String query, SearchQueryField field, Sort sort) {
        return getAuthors(query, field, 0, 0, sort);
    }

    public Optional<List<Author>> getAuthors(String query, SearchQueryField field, String... fields) {
        return getAuthors(query, field, 0, 0, null, fields);
    }

    public Optional<List<Author>> getAuthors(String query, Sort sort, String... fields) {
        return getAuthors(query, null, 0, 0, sort, fields);
    }

    public Optional<List<Author>> getAuthors(String query, SearchQueryField field, int size, int page) {
        return getAuthors(query, field, size, page, null);
    }

    public Optional<List<Author>> getAuthors(String query, int size, int page, String... fields) {
        return getAuthors(query, null, size, page, null);
    }

    public Optional<List<Author>> getAuthors(String query, SearchQueryField field, int size, int page,
                                             Sort sort, String... fields) {
        if (isQueryInvalid(query)) {
            return Optional.empty();
        }

        List<Object> responseList = responseBuilder.getResponseWithParametersAsList(
                "search/authors/" + URLEncoder.encode(query, StandardCharsets.UTF_8), Author.class,
                new Parameter("field", field != null ? field.getName() : null), new Parameter("size", size),
                new Parameter("page", page), new Parameter("sort", sort != null ? sort.toString() : null),
                new Parameter("fields", fields != null ? String.join(",", fields) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Author> authorList = new ArrayList<>();
        responseList.forEach(object -> authorList.add((Author) object));

        return Optional.of(authorList);
    }

    public Optional<List<Resource>> getResources(String query) {
        return getResources(query, null, 0, 0, null);
    }

    public Optional<List<Resource>> getResources(String query, SearchQueryField field) {
        return getResources(query, field, 0, 0, null);
    }

    public Optional<List<Resource>> getResources(String query, Sort sort) {
        return getResources(query, null, 0, 0, sort);
    }

    public Optional<List<Resource>> getResources(String query, String... fields) {
        return getResources(query, null, 0, 0, null, fields);
    }

    public Optional<List<Resource>> getResources(String query, int size, int page) {
        return getResources(query, null, size, page, null);
    }

    public Optional<List<Resource>> getResources(String query, SearchQueryField field, Sort sort) {
        return getResources(query, field, 0, 0, sort);
    }

    public Optional<List<Resource>> getResources(String query, SearchQueryField field, String... fields) {
        return getResources(query, field, 0, 0, null, fields);
    }

    public Optional<List<Resource>> getResources(String query, Sort sort, String... fields) {
        return getResources(query, null, 0, 0, sort, fields);
    }

    public Optional<List<Resource>> getResources(String query, SearchQueryField field, int size, int page) {
        return getResources(query, field, size, page, null);
    }

    public Optional<List<Resource>> getResources(String query, int size, int page, String... fields) {
        return getResources(query, null, size, page, null);
    }

    public Optional<List<Resource>> getResources(String query, SearchQueryField field, int size, int page,
                                                 Sort sort, String... fields) {
        if (isQueryInvalid(query)) {
            return Optional.empty();
        }

        List<Object> responseList = responseBuilder.getResponseWithParametersAsList(
                "search/resources/" + URLEncoder.encode(query, StandardCharsets.UTF_8), Resource.class,
                new Parameter("field", field != null ? field.getName() : null), new Parameter("size", size),
                new Parameter("page", page), new Parameter("sort", sort != null ? sort.toString() : null),
                new Parameter("fields", fields != null ? String.join(",", fields) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Resource> resourceList = new ArrayList<>();
        responseList.forEach(object -> resourceList.add((Resource) object));

        return Optional.of(resourceList);
    }

    private boolean isQueryInvalid(String query) {
        return query == null || query.isEmpty() || query.replaceAll("\\s+", "").isEmpty();
    }
}
