package edu.ucar.cisl.report.machineactivity;

import edu.ucar.cisl.report.ReportGenerator;
import edu.ucar.cisl.report.UriBuilder;
import org.springframework.web.client.RestTemplate;

public class MachineActivityReportGenerator implements ReportGenerator<MachineActivityReport, MachineActivityReportParameters> {

    private final RestTemplate restTemplate;
    private final UriBuilder<MachineActivityReportParameters> uriBuilder;

    public MachineActivityReportGenerator(RestTemplate restTemplate, UriBuilder<MachineActivityReportParameters> uriBuilder) {
        this.restTemplate = restTemplate;
        this.uriBuilder = uriBuilder;
    }

    @Override
    public MachineActivityReport generate(MachineActivityReportParameters parameters) {
        return restTemplate.getForObject(uriBuilder.build(parameters), MachineActivityReport.class);
    }
}
