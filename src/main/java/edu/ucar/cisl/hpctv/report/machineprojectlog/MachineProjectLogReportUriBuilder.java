package edu.ucar.cisl.hpctv.report.machineprojectlog;

import edu.ucar.cisl.hpctv.report.BaseUriBuilder;
import edu.ucar.cisl.hpctv.report.UriBuilder;
import edu.ucar.cisl.hpctv.report.CommonUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class MachineProjectLogReportUriBuilder extends BaseUriBuilder<MachineProjectLogReportParameters> implements UriBuilder<MachineProjectLogReportParameters> {

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
