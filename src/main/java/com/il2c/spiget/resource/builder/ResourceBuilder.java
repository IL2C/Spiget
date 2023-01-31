package com.il2c.spiget.resource.builder;

import com.il2c.spiget.author.response.Author;
import com.il2c.spiget.global.parameter.Sort;
import com.il2c.spiget.resource.parameter.VersionMethod;
import com.il2c.spiget.resource.response.*;
import com.il2c.spiget.response.builder.ResponseBuilder;
import com.il2c.spiget.response.parameter.Parameter;

import java.io.BufferedInputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResourceBuilder {

    private final ResponseBuilder responseBuilder;

    public ResourceBuilder(ResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    public Optional<List<Resource>> getResources() {
        return getResources(0, 0, null);
    }

    public Optional<List<Resource>> getResources(Sort sort) {
        return getResources(0, 0, sort);
    }

    public Optional<List<Resource>> getResources(String... fields) {
        return getResources(0, 0, null, fields);
    }

    public Optional<List<Resource>> getResources(int size, int page) {
        return getResources(size, page, null);
    }

    public Optional<List<Resource>> getResources(Sort sort, String... fields) {
        return getResources(0, 0, sort, fields);
    }

    public Optional<List<Resource>> getResources(int size, int page, Sort sort, String... fields) {
        List<Object> responseList =
                responseBuilder.getResponseWithParametersAsList("resources", Resource.class,
                        new Parameter("size", size), new Parameter("page", page),
                        new Parameter("sort", sort != null ? sort.toString() : null),
                        new Parameter("fields", fields != null ? String.join(",", fields) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Resource> resourceList = new ArrayList<>();
        responseList.forEach(object -> resourceList.add((Resource) object));

        return Optional.of(resourceList);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String version) {
        return getResourcesForVersion(version, null, 0, 0, null);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions) {
        return getResourcesForVersion(versions, null, 0, 0, null);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, VersionMethod method) {
        return getResourcesForVersion(version, method, 0, 0, null);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, VersionMethod method) {
        return getResourcesForVersion(versions, method, 0, 0, null);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, Sort sort) {
        return getResourcesForVersion(version, null, 0, 0, sort);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, Sort sort) {
        return getResourcesForVersion(versions, null, 0, 0, sort);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, String... fields) {
        return getResourcesForVersion(version, null, 0, 0, null, fields);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, String... fields) {
        return getResourcesForVersion(versions, null, 0, 0, null, fields);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, int size, int page) {
        return getResourcesForVersion(version, null, size, page, null);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, int size, int page) {
        return getResourcesForVersion(versions, null, size, page, null);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, VersionMethod method,
                                                                Sort sort) {
        return getResourcesForVersion(version, method, 0, 0, sort);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, VersionMethod method,
                                                                Sort sort) {
        return getResourcesForVersion(versions, method, 0, 0, sort);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, VersionMethod method,
                                                                String... fields) {
        return getResourcesForVersion(version, method, 0, 0, null, fields);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, VersionMethod method,
                                                                String... fields) {
        return getResourcesForVersion(versions, method, 0, 0, null, fields);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, Sort sort, String... fields) {
        return getResourcesForVersion(version, null, 0, 0, sort, fields);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, Sort sort,
                                                                String... fields) {
        return getResourcesForVersion(versions, null, 0, 0, sort, fields);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, VersionMethod method,
                                                                int size, int page) {
        return getResourcesForVersion(version, method, size, page, null);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, VersionMethod method,
                                                                int size, int page) {
        return getResourcesForVersion(versions, method, size, page, null);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, int size, int page,
                                                                String... fields) {
        return getResourcesForVersion(version, null, size, page, null);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, int size, int page,
                                                                String... fields) {
        return getResourcesForVersion(versions, null, size, page, null);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, VersionMethod method,
                                                                int size, int page, Sort sort,
                                                                String... fields) {
        return getResourcesForVersion(
                version != null && !(version.isEmpty() || version.replaceAll("\\s+", "").isEmpty()) ?
                new String[]{version} : null, method, size, page, sort, fields);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, VersionMethod method,
                                                                int size, int page, Sort sort,
                                                                String... fields) {
        if (versions == null || versions.length == 0) {
            return Optional.empty();
        }

        Object responseObject = responseBuilder.getResponseWithParametersAsObject(
                "resources/for/" + URLEncoder.encode(String.join(",", versions), StandardCharsets.UTF_8),
                ResourcesForVersion.class, new Parameter("method", method != null ? method.getName() : null),
                new Parameter("size", size), new Parameter("page", page),
                new Parameter("sort", sort != null ? sort.toString() : null),
                new Parameter("fields", fields != null ? String.join(",", fields) : null));

        return Optional.ofNullable((ResourcesForVersion) responseObject);
    }

    public Optional<List<Resource>> getFreeResources() {
        return getFreeResources(0, 0, null);
    }

    public Optional<List<Resource>> getFreeResources(Sort sort) {
        return getFreeResources(0, 0, sort);
    }

    public Optional<List<Resource>> getFreeResources(String... fields) {
        return getFreeResources(0, 0, null, fields);
    }

    public Optional<List<Resource>> getFreeResources(int size, int page) {
        return getFreeResources(size, page, null);
    }

    public Optional<List<Resource>> getFreeResources(Sort sort, String... fields) {
        return getFreeResources(0, 0, sort, fields);
    }

    public Optional<List<Resource>> getFreeResources(int size, int page, Sort sort, String... fields) {
        List<Object> responseList =
                responseBuilder.getResponseWithParametersAsList("resources/free", Resource.class,
                        new Parameter("size", size), new Parameter("page", page),
                        new Parameter("sort", sort != null ? sort.toString() : null),
                        new Parameter("fields", fields != null ? String.join(",", fields) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Resource> resourceList = new ArrayList<>();
        responseList.forEach(object -> resourceList.add((Resource) object));

        return Optional.of(resourceList);
    }

    public Optional<List<Resource>> getNewResources() {
        return getNewResources(0, 0, null);
    }

    public Optional<List<Resource>> getNewResources(Sort sort) {
        return getNewResources(0, 0, sort);
    }

    public Optional<List<Resource>> getNewResources(String... fields) {
        return getNewResources(0, 0, null, fields);
    }

    public Optional<List<Resource>> getNewResources(int size, int page) {
        return getNewResources(size, page, null);
    }

    public Optional<List<Resource>> getNewResources(Sort sort, String... fields) {
        return getNewResources(0, 0, sort, fields);
    }

    public Optional<List<Resource>> getNewResources(int size, int page, Sort sort, String... fields) {
        List<Object> responseList =
                responseBuilder.getResponseWithParametersAsList("resources/new", Resource.class,
                        new Parameter("size", size), new Parameter("page", page),
                        new Parameter("sort", sort != null ? sort.toString() : null),
                        new Parameter("fields", fields != null ? String.join(",", fields) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Resource> resourceList = new ArrayList<>();
        responseList.forEach(object -> resourceList.add((Resource) object));

        return Optional.of(resourceList);
    }

    public Optional<List<Resource>> getPremiumResources() {
        return getPremiumResources(0, 0, null);
    }

    public Optional<List<Resource>> getPremiumResources(Sort sort) {
        return getPremiumResources(0, 0, sort);
    }

    public Optional<List<Resource>> getPremiumResources(String... fields) {
        return getPremiumResources(0, 0, null, fields);
    }

    public Optional<List<Resource>> getPremiumResources(int size, int page) {
        return getPremiumResources(size, page, null);
    }

    public Optional<List<Resource>> getPremiumResources(Sort sort, String... fields) {
        return getPremiumResources(0, 0, sort, fields);
    }

    public Optional<List<Resource>> getPremiumResources(int size, int page, Sort sort, String... fields) {
        List<Object> responseList =
                responseBuilder.getResponseWithParametersAsList("resources/premium", Resource.class,
                        new Parameter("size", size), new Parameter("page", page),
                        new Parameter("sort", sort != null ? sort.toString() : null),
                        new Parameter("fields", fields != null ? String.join(",", fields) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Resource> resourceList = new ArrayList<>();
        responseList.forEach(object -> resourceList.add((Resource) object));

        return Optional.of(resourceList);
    }

    public Optional<Resource> getResource(int id) {
        return Optional.ofNullable(
                (Resource) responseBuilder.getResponseWithoutParameters("resources/" + id, Resource.class));
    }

    public Optional<Author> getResourceAuthor(int id) {
        return Optional.ofNullable(
                (Author) responseBuilder.getResponseWithoutParameters("resources/" + id + "/author",
                        Author.class));
    }

    public Optional<BufferedInputStream> getResourceDownload(int id) {
        return Optional.ofNullable(responseBuilder.getResponseForDownload("resources/" + id + "/download"));
    }

    public Optional<List<Review>> getResourceReviews(int id) {
        return getResourceReviews(id, 0, 0, null);
    }

    public Optional<List<Review>> getResourceReviews(int id, Sort sort) {
        return getResourceReviews(id, 0, 0, sort);
    }

    public Optional<List<Review>> getResourceReviews(int id, String... fields) {
        return getResourceReviews(id, 0, 0, null, fields);
    }

    public Optional<List<Review>> getResourceReviews(int id, int size, int page) {
        return getResourceReviews(id, size, page, null);
    }

    public Optional<List<Review>> getResourceReviews(int id, Sort sort, String... fields) {
        return getResourceReviews(id, 0, 0, sort, fields);
    }

    public Optional<List<Review>> getResourceReviews(int id, int size, int page, Sort sort,
                                                     String... fields) {
        List<Object> responseList =
                responseBuilder.getResponseWithParametersAsList("resources/" + id + "/reviews", Review.class,
                        new Parameter("size", size), new Parameter("page", page),
                        new Parameter("sort", sort != null ? sort.toString() : null),
                        new Parameter("fields", fields != null ? String.join(",", fields) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Review> reviewList = new ArrayList<>();
        responseList.forEach(object -> reviewList.add((Review) object));

        return Optional.of(reviewList);
    }

    public Optional<List<Update>> getResourceUpdates(int id) {
        return getResourceUpdates(id, 0, 0, null);
    }

    public Optional<List<Update>> getResourceUpdates(int id, Sort sort) {
        return getResourceUpdates(id, 0, 0, sort);
    }

    public Optional<List<Update>> getResourceUpdates(int id, String... fields) {
        return getResourceUpdates(id, 0, 0, null, fields);
    }

    public Optional<List<Update>> getResourceUpdates(int id, int size, int page) {
        return getResourceUpdates(id, size, page, null);
    }

    public Optional<List<Update>> getResourceUpdates(int id, Sort sort, String... fields) {
        return getResourceUpdates(id, 0, 0, sort, fields);
    }

    public Optional<List<Update>> getResourceUpdates(int id, int size, int page, Sort sort,
                                                     String... fields) {
        List<Object> responseList =
                responseBuilder.getResponseWithParametersAsList("resources/" + id + "/updates", Update.class,
                        new Parameter("size", size), new Parameter("page", page),
                        new Parameter("sort", sort != null ? sort.toString() : null),
                        new Parameter("fields", fields != null ? String.join(",", fields) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Update> updateList = new ArrayList<>();
        responseList.forEach(object -> updateList.add((Update) object));

        return Optional.of(updateList);
    }

    public Optional<Update> getLatestResourceUpdate(int id) {
        return Optional.ofNullable(
                (Update) responseBuilder.getResponseWithoutParameters("resources/" + id + "/updates/latest",
                        Update.class));
    }

    public Optional<List<Version>> getResourceVersions(int id) {
        return getResourceVersions(id, 0, 0, null);
    }

    public Optional<List<Version>> getResourceVersions(int id, Sort sort) {
        return getResourceVersions(id, 0, 0, sort);
    }

    public Optional<List<Version>> getResourceVersions(int id, String... fields) {
        return getResourceVersions(id, 0, 0, null, fields);
    }

    public Optional<List<Version>> getResourceVersions(int id, int size, int page) {
        return getResourceVersions(id, size, page, null);
    }

    public Optional<List<Version>> getResourceVersions(int id, Sort sort, String... fields) {
        return getResourceVersions(id, 0, 0, sort, fields);
    }

    public Optional<List<Version>> getResourceVersions(int id, int size, int page, Sort sort,
                                                       String... fields) {
        List<Object> responseList =
                responseBuilder.getResponseWithParametersAsList("resources/" + id + "/versions",
                        Version.class, new Parameter("size", size), new Parameter("page", page),
                        new Parameter("sort", sort != null ? sort.toString() : null),
                        new Parameter("fields", fields != null ? String.join(",", fields) : null));

        if (responseList == null) {
            return Optional.empty();
        }

        List<Version> versionList = new ArrayList<>();
        responseList.forEach(object -> versionList.add((Version) object));

        return Optional.of(versionList);
    }

    public Optional<Version> getLatestResourceVersion(int id) {
        return Optional.ofNullable(
                (Version) responseBuilder.getResponseWithoutParameters("resources/" + id + "/versions/latest",
                        Version.class));
    }

    public Optional<Version> getResourceVersion(int resourceID, int versionID) {
        return Optional.ofNullable((Version) responseBuilder.getResponseWithoutParameters(
                "resources/" + resourceID + "/versions/" + versionID, Version.class));
    }

    public Optional<BufferedInputStream> getResourceVersionDownload(int resourceID, int versionID) {
        return Optional.ofNullable(responseBuilder.getResponseForDownload(
                "resources/" + resourceID + "/versions/" + versionID + "/download"));
    }
}