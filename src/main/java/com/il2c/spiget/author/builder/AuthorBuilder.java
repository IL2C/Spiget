package com.il2c.spiget.author.builder;

import com.google.gson.JsonElement;
import com.il2c.spiget.SpigetAPI;
import com.il2c.spiget.author.response.Author;
import com.il2c.spiget.global.SortOrder;
import com.il2c.spiget.resource.response.Resource;
import com.il2c.spiget.resource.response.Review;
import com.il2c.spiget.web.builder.WebBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorBuilder {

    private final WebBuilder webBuilder;

    public AuthorBuilder(SpigetAPI api) {
        this.webBuilder = api.getWebBuilder();
    }

    public Optional<List<Author>> getAuthors() {
        return getAuthors(0, 0, null);
    }

    public Optional<List<Author>> getAuthors(SortOrder sort) {
        return getAuthors(0, 0, sort);
    }

    public Optional<List<Author>> getAuthors(String... fields) {
        return getAuthors(0, 0, null, fields);
    }

    public Optional<List<Author>> getAuthors(int size, int page) {
        return getAuthors(size, page, null);
    }

    public Optional<List<Author>> getAuthors(SortOrder sort, String... fields) {
        return getAuthors(0, 0, sort, fields);
    }

    public Optional<List<Author>> getAuthors(int size, int page, SortOrder sort, String... fields) {
        String parameters = (size == 0 ? "" : "size=" + size);
        parameters += (page == 0 ? "" : (parameters.isEmpty() ? "" : "&") + "page=" + page);
        parameters += (sort == null ? "" : (parameters.isEmpty() ? "" : "&") + "sort=" + sort.getCode());
        parameters += (fields == null || fields.length == 0 ? "" :
                       (parameters.isEmpty() ? "" : "&") + "fields=" +
                       URLEncoder.encode(String.join(",", fields), StandardCharsets.UTF_8));
        parameters = parameters.isEmpty() ? "" : "?" + parameters;

        JsonElement jsonElement = webBuilder.getResponse("authors" + parameters).orElse(null);

        if (jsonElement == null) {
            return Optional.empty();
        }

        List<Author> authorList = new ArrayList<>();

        jsonElement.getAsJsonArray().asList()
                   .forEach(author -> authorList.add(webBuilder.getGson().fromJson(author, Author.class)));

        return Optional.of(authorList);
    }

    public Optional<Author> getAuthor(int id) {
        return webBuilder.getResponse("authors/" + id)
                         .map(jsonElement -> webBuilder.getGson().fromJson(jsonElement, Author.class));
    }

    public Optional<List<Resource>> getAuthorResources(int id) {
        return getAuthorResources(id, 0, 0, null);
    }

    public Optional<List<Resource>> getAuthorResources(int id, SortOrder sort) {
        return getAuthorResources(id, 0, 0, sort);
    }

    public Optional<List<Resource>> getAuthorResources(int id, String... fields) {
        return getAuthorResources(id, 0, 0, null, fields);
    }

    public Optional<List<Resource>> getAuthorResources(int id, int size, int page) {
        return getAuthorResources(id, size, page, null);
    }

    public Optional<List<Resource>> getAuthorResources(int id, SortOrder sort, String... fields) {
        return getAuthorResources(id, 0, 0, sort, fields);
    }

    public Optional<List<Resource>> getAuthorResources(int id, int size, int page, SortOrder sort,
                                                       String... fields) {
        String parameters = (size == 0 ? "" : "size=" + size);
        parameters += (page == 0 ? "" : (parameters.isEmpty() ? "" : "&") + "page=" + page);
        parameters += (sort == null ? "" : (parameters.isEmpty() ? "" : "&") + "sort=" + sort.getCode());
        parameters += (fields == null || fields.length == 0 ? "" :
                       (parameters.isEmpty() ? "" : "&") + "fields=" +
                       URLEncoder.encode(String.join(",", fields), StandardCharsets.UTF_8));
        parameters = parameters.isEmpty() ? "" : "?" + parameters;

        JsonElement jsonElement =
                webBuilder.getResponse("authors/" + id + "/resources" + parameters).orElse(null);

        if (jsonElement == null) {
            return Optional.empty();
        }

        List<Resource> resourcesList = new ArrayList<>();

        jsonElement.getAsJsonArray().asList().forEach(
                resource -> resourcesList.add(webBuilder.getGson().fromJson(resource, Resource.class)));

        return Optional.of(resourcesList);
    }

    public Optional<List<Review>> getAuthorReviews(int id) {
        return getAuthorReviews(id, 0, 0, null);
    }

    public Optional<List<Review>> getAuthorReviews(int id, SortOrder sort) {
        return getAuthorReviews(id, 0, 0, sort);
    }

    public Optional<List<Review>> getAuthorReviews(int id, String... fields) {
        return getAuthorReviews(id, 0, 0, null, fields);
    }

    public Optional<List<Review>> getAuthorReviews(int id, int size, int page) {
        return getAuthorReviews(id, size, page, null);
    }

    public Optional<List<Review>> getAuthorReviews(int id, SortOrder sort, String... fields) {
        return getAuthorReviews(id, 0, 0, sort, fields);
    }

    public Optional<List<Review>> getAuthorReviews(int id, int size, int page, SortOrder sort,
                                                   String... fields) {
        String parameters = (size == 0 ? "" : "size=" + size);
        parameters += (page == 0 ? "" : (parameters.isEmpty() ? "" : "&") + "page=" + page);
        parameters += (sort == null ? "" : (parameters.isEmpty() ? "" : "&") + "sort=" + sort.getCode());
        parameters += (fields == null || fields.length == 0 ? "" :
                       (parameters.isEmpty() ? "" : "&") + "fields=" +
                       URLEncoder.encode(String.join(",", fields), StandardCharsets.UTF_8));
        parameters = parameters.isEmpty() ? "" : "?" + parameters;

        JsonElement jsonElement =
                webBuilder.getResponse("authors/" + id + "/reviews" + parameters).orElse(null);

        if (jsonElement == null) {
            return Optional.empty();
        }

        List<Review> reviewList = new ArrayList<>();

        jsonElement.getAsJsonArray().asList()
                   .forEach(review -> reviewList.add(webBuilder.getGson().fromJson(review, Review.class)));

        return Optional.of(reviewList);
    }
}
