package edu.ucar.cisl.report;

import org.springframework.web.client.RestTemplate;

public class RestTemplateReportGenerator<R, P> implements ReportGenerator<R, P> {

    private final RestTemplate restTemplate;
    private final UriBuilder<P> uriBuilder;
    private final ReportClassSupplier<R> reportClassSupplier;

    public RestTemplateReportGenerator(RestTemplate restTemplate, UriBuilder<P> uriBuilder, ReportClassSupplier<R> reportClassSupplier) {
        this.restTemplate = restTemplate;
        this.uriBuilder = uriBuilder;
        this.reportClassSupplier = reportClassSupplier;
    }

    @Override
    public R generate(P parameters) {
        return restTemplate.getForObject(uriBuilder.build(parameters), reportClassSupplier.reportClass());
    }
}

