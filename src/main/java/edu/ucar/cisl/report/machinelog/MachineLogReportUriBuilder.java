package edu.ucar.cisl.report.machinelog;

import edu.ucar.cisl.report.AbstractUriBuilder;
import edu.ucar.cisl.report.CommonUriComponentsBuilder;
import edu.ucar.cisl.report.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class MachineLogReportUriBuilder extends AbstractUriBuilder<MachineLogReportParameters> implements UriBuilder<MachineLogReportParameters> {

    public MachineLogReportUriBuilder(CommonUriComponentsBuilder commonUriComponentsBuilder) {
        super(commonUriComponentsBuilder);
    }

    @Override
    protected UriComponentsBuilder addQueryParams(UriComponentsBuilder builder, MachineLogReportParameters parameters) {
        return builder.queryParam("daysAgo", parameters.getDaysAgo());
    }

    @Override
    protected void addUriParams(Map<String, String> uriParams, MachineLogReportParameters parameters) {
        uriParams.put("machine", parameters.getMachine());
    }

}
