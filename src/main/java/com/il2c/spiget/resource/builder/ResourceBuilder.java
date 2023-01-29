package com.il2c.spiget.resource.builder;

import com.google.gson.JsonElement;
import com.il2c.spiget.SpigetAPI;
import com.il2c.spiget.global.SortOrder;
import com.il2c.spiget.resource.parameter.VersionMethod;
import com.il2c.spiget.resource.response.Resource;
import com.il2c.spiget.resource.response.ResourcesForVersion;
import com.il2c.spiget.web.builder.WebBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResourceBuilder {

    private final WebBuilder webBuilder;

    public ResourceBuilder(SpigetAPI api) {
        this.webBuilder = api.getWebBuilder();
    }

    public Optional<List<Resource>> getResources() {
        return getResources(0, 0, null);
    }

    public Optional<List<Resource>> getResources(SortOrder sort) {
        return getResources(0, 0, sort);
    }

    public Optional<List<Resource>> getResources(String... fields) {
        return getResources(0, 0, null, fields);
    }

    public Optional<List<Resource>> getResources(int size, int page) {
        return getResources(size, page, null);
    }

    public Optional<List<Resource>> getResources(SortOrder sort, String... fields) {
        return getResources(0, 0, sort, fields);
    }

    public Optional<List<Resource>> getResources(int size, int page, SortOrder sort, String... fields) {
        String parameters = (size == 0 ? "" : "size=" + size);
        parameters += (page == 0 ? "" : (parameters.isEmpty() ? "" : "&") + "page=" + page);
        parameters += (sort == null ? "" : (parameters.isEmpty() ? "" : "&") + "sort=" + sort.getCode());
        parameters += (fields == null || fields.length == 0 ? "" :
                       (parameters.isEmpty() ? "" : "&") + "fields=" +
                       URLEncoder.encode(String.join(",", fields), StandardCharsets.UTF_8));
        parameters = parameters.isEmpty() ? "" : "?" + parameters;

        JsonElement jsonElement = webBuilder.getResponse("resources" + parameters).orElse(null);

        if (jsonElement == null) {
            return Optional.empty();
        }

        List<Resource> resourceList = new ArrayList<>();

        jsonElement.getAsJsonArray().asList().forEach(
                resource -> resourceList.add(webBuilder.getGson().fromJson(resource, Resource.class)));

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

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, SortOrder sort) {
        return getResourcesForVersion(version, null, 0, 0, sort);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, SortOrder sort) {
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
                                                                SortOrder sort) {
        return getResourcesForVersion(version, method, 0, 0, sort);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, VersionMethod method,
                                                                SortOrder sort) {
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

    public Optional<ResourcesForVersion> getResourcesForVersion(String version, SortOrder sort,
                                                                String... fields) {
        return getResourcesForVersion(version, null, 0, 0, sort, fields);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, SortOrder sort,
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
                                                                int size, int page, SortOrder sort,
                                                                String... fields) {
        return getResourcesForVersion(
                version != null && !(version.isEmpty() || version.replaceAll("\\s+", "").isEmpty()) ?
                new String[]{version} : null, method, size, page, sort, fields);
    }

    public Optional<ResourcesForVersion> getResourcesForVersion(String[] versions, VersionMethod method,
                                                                int size,
                                                                int page, SortOrder sort, String... fields) {
        if (versions == null || versions.length == 0) {
            return Optional.empty();
        }

        String parameters = (method == null ? "" : "method=" + method.getName());
        parameters += (size == 0 ? "" : (parameters.isEmpty() ? "" : "&") + "size=" + size);
        parameters += (page == 0 ? "" : (parameters.isEmpty() ? "" : "&") + "page=" + page);
        parameters += (sort == null ? "" : (parameters.isEmpty() ? "" : "&") + "sort=" + sort.getCode());
        parameters += (fields == null || fields.length == 0 ? "" :
                       (parameters.isEmpty() ? "" : "&") + "fields=" +
                       URLEncoder.encode(String.join(",", fields), StandardCharsets.UTF_8));
        parameters = parameters.isEmpty() ? "" : "?" + parameters;

        JsonElement jsonElement = webBuilder.getResponse(
                "resources/for/" + URLEncoder.encode(String.join(",", versions), StandardCharsets.UTF_8) +
                parameters).orElse(null);

        return jsonElement != null ?
               Optional.of(webBuilder.getGson().fromJson(jsonElement, ResourcesForVersion.class)) :
               Optional.empty();
    }
}
