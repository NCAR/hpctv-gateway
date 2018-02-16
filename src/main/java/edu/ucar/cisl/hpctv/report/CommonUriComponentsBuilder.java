package edu.ucar.cisl.hpctv.report;

import org.springframework.web.util.UriComponentsBuilder;

public class CommonUriComponentsBuilder {

    private String scheme;
    private String host;
    private String port;

    public UriComponentsBuilder build() {
        return UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .port(port);
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
