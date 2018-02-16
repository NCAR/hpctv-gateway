package edu.ucar.cisl.hpctv.report;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseUriBuilder<P> implements UriBuilder<P> {

    private final CommonUriComponentsBuilder commonUriComponentsBuilder;

    private String path;

    public BaseUriBuilder(CommonUriComponentsBuilder commonUriComponentsBuilder) {
        this.commonUriComponentsBuilder = commonUriComponentsBuilder;
    }

    public URI build(P parameters) {
        return addQueryParams(buildUriComponents(), parameters)
                .buildAndExpand(getUriParams(parameters))
                .toUri();
    }

    protected UriComponentsBuilder addQueryParams(UriComponentsBuilder builder, P parameters) {
        return builder;
    }

    private UriComponentsBuilder buildUriComponents() {
        return commonUriComponentsBuilder.build().path(path);
    }

    private Map<String, String> getUriParams(P parameters) {
        Map<String, String> uriParams = new HashMap<>();
        addUriParams(uriParams, parameters);
        return uriParams;
    }

    protected void addUriParams(Map<String, String> uriParams, P parameters) {
    }

    public void setPath(String path) {
        this.path = path;
    }
}
