package com.il2c.spiget.search.builder;

import com.google.gson.JsonElement;
import com.il2c.spiget.SpigetAPI;
import com.il2c.spiget.author.response.Author;
import com.il2c.spiget.global.SortOrder;
import com.il2c.spiget.search.parameter.SearchQueryField;
import com.il2c.spiget.web.builder.WebBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchBuilder {

    private final WebBuilder webBuilder;

    public SearchBuilder(SpigetAPI api) {
        this.webBuilder = api.getWebBuilder();
    }

    public Optional<List<Author>> getAuthors(String query) {
        return getAuthors(query, null, 0, 0, null);
    }

    public Optional<List<Author>> getAuthors(String query, SearchQueryField field) {
        return getAuthors(query, field, 0, 0, null);
    }

    public Optional<List<Author>> getAuthors(String query, SortOrder sort) {
        return getAuthors(query, null, 0, 0, sort);
    }

    public Optional<List<Author>> getAuthors(String query, String... fields) {
        return getAuthors(query, null, 0, 0, null, fields);
    }

    public Optional<List<Author>> getAuthors(String query, int size, int page) {
        return getAuthors(query, null, size, page, null);
    }

    public Optional<List<Author>> getAuthors(String query, SearchQueryField field,
                                             SortOrder sort) {
        return getAuthors(query, field, 0, 0, sort);
    }

    public Optional<List<Author>> getAuthors(String query, SearchQueryField field,
                                             String... fields) {
        return getAuthors(query, field, 0, 0, null, fields);
    }

    public Optional<List<Author>> getAuthors(String query, SortOrder sort, String... fields) {
        return getAuthors(query, null, 0, 0, sort, fields);
    }

    public Optional<List<Author>> getAuthors(String query, SearchQueryField field, int size,
                                             int page) {
        return getAuthors(query, field, size, page, null);
    }

    public Optional<List<Author>> getAuthors(String query, int size, int page, String... fields) {
        return getAuthors(query, null, size, page, null);
    }

    public Optional<List<Author>> getAuthors(String query, SearchQueryField field, int size, int page,
                                             SortOrder sort, String... fields) {
        if (query == null || query.isEmpty() || query.replaceAll("\\s+", "").isEmpty()) {
            return Optional.empty();
        }

        String parameters = (field == null ? "" : "field=" + field.getName());
        parameters += (size == 0 ? "" : (parameters.isEmpty() ? "" : "&") + "size=" + size);
        parameters += (page == 0 ? "" : (parameters.isEmpty() ? "" : "&") + "page=" + page);
        parameters += (sort == null ? "" : (parameters.isEmpty() ? "" : "&") + "sort=" + sort.getCode());
        parameters += (fields == null || fields.length == 0 ? "" :
                       (parameters.isEmpty() ? "" : "&") + "fields=" +
                       URLEncoder.encode(String.join(",", fields), StandardCharsets.UTF_8));
        parameters = parameters.isEmpty() ? "" : "?" + parameters;

        JsonElement jsonElement = webBuilder.getResponse(
                                                    "search/authors/" + URLEncoder.encode(query, StandardCharsets.UTF_8) + parameters)
                                            .orElse(null);

        if (jsonElement == null) {
            return Optional.empty();
        }

        List<Author> authorList = new ArrayList<>();

        jsonElement.getAsJsonArray().asList()
                   .forEach(author -> authorList.add(webBuilder.getGson().fromJson(author, Author.class)));

        return Optional.of(authorList);
    }
}
