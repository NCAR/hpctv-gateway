package edu.ucar.cisl.report;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUriBuilder<P> implements UriBuilder<P> {

    private final CommonUriComponentsBuilder commonUriComponentsBuilder;

    private String path;

    public AbstractUriBuilder(CommonUriComponentsBuilder commonUriComponentsBuilder) {
        this.commonUriComponentsBuilder = commonUriComponentsBuilder;
    }

    public URI build(P parameters) {
        return addRequestParams(buildUriComponents(), parameters)
                .buildAndExpand(getUriParams(parameters))
                .toUri();
    }

    protected UriComponentsBuilder addRequestParams(UriComponentsBuilder builder, P parameters) {
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
