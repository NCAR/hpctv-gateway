package edu.ucar.cisl.report.machinetotal;

import edu.ucar.cisl.report.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class MachineTotalReportUriBuilder implements UriBuilder<MachineTotalReportParameters> {

    private String scheme;
    private String host;
    private String port;
    private String path;

    @Override
    public URI build(MachineTotalReportParameters parameters) {
        return UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .port(port)
                .path(path)
                .buildAndExpand(getUriParams(parameters)).toUri();
    }

    private Map<String, String> getUriParams(MachineTotalReportParameters parameters) {
        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("machine", parameters.getMachine());
        return uriParams;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
