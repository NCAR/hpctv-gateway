package edu.ucar.cisl.report.machineprojectlog;

import edu.ucar.cisl.report.AbstractUriBuilder;
import edu.ucar.cisl.report.CommonUriComponentsBuilder;
import edu.ucar.cisl.report.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class MachineProjectLogReportUriBuilder extends AbstractUriBuilder<MachineProjectLogReportParameters> implements UriBuilder<MachineProjectLogReportParameters> {

    public MachineProjectLogReportUriBuilder(CommonUriComponentsBuilder commonUriComponentsBuilder) {
        super(commonUriComponentsBuilder);
    }

    @Override
    protected UriComponentsBuilder addQueryParams(UriComponentsBuilder builder, MachineProjectLogReportParameters parameters) {
        return builder.queryParam("daysAgo", parameters.getDaysAgo());
    }

    @Override
    protected void addUriParams(Map<String, String> uriParams, MachineProjectLogReportParameters parameters) {
        uriParams.put("machine", parameters.getMachine());
    }
}
