package com.il2c.spiget.author.builder;

import com.il2c.spiget.author.response.Author;
import com.il2c.spiget.global.SortOrder;
import com.il2c.spiget.resource.response.Resource;
import com.il2c.spiget.resource.response.Review;
import com.il2c.spiget.response.builder.ResponseBuilder;
import com.il2c.spiget.response.parameter.Parameter;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorBuilder {

    private final ResponseBuilder responseBuilder;

    public AuthorBuilder(ResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
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
        List<Object> responseList = responseBuilder.getResponseWithParametersAsList("authors", Author.class,
                new Parameter("size", size), new Parameter("page", page),
                new Parameter("sort", sort != null ? sort.getCode() : null), new Parameter("fields",
                        fields != null ? URLEncoder.encode(String.join(",", fields), StandardCharsets.UTF_8) :
                        null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Author> authorList = new ArrayList<>();
        responseList.forEach(object -> authorList.add((Author) object));

        return Optional.of(authorList);
    }

    public Optional<Author> getAuthor(int id) {
        return Optional.ofNullable(
                (Author) responseBuilder.getResponseWithoutParameters("authors/" + id, Author.class));
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
        List<Object> responseList =
                responseBuilder.getResponseWithParametersAsList("authors/" + id + "/resources",
                        Resource.class, new Parameter("size", size), new Parameter("page", page),
                        new Parameter("sort", sort != null ? sort.getCode() : null), new Parameter("fields",
                                fields != null ?
                                URLEncoder.encode(String.join(",", fields), StandardCharsets.UTF_8) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Resource> resourceList = new ArrayList<>();
        responseList.forEach(object -> resourceList.add((Resource) object));

        return Optional.of(resourceList);
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
        List<Object> responseList =
                responseBuilder.getResponseWithParametersAsList("authors/" + id + "/reviews", Review.class,
                        new Parameter("size", size), new Parameter("page", page),
                        new Parameter("sort", sort != null ? sort.getCode() : null), new Parameter("fields",
                                fields != null ?
                                URLEncoder.encode(String.join(",", fields), StandardCharsets.UTF_8) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Review> reviewList = new ArrayList<>();
        responseList.forEach(object -> reviewList.add((Review) object));

        return Optional.of(reviewList);
    }
}
