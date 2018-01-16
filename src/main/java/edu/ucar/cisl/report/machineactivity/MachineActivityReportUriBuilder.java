package edu.ucar.cisl.report.machineactivity;

import edu.ucar.cisl.report.BaseUriBuilder;
import edu.ucar.cisl.report.CommonUriComponentsBuilder;
import edu.ucar.cisl.report.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class MachineActivityReportUriBuilder extends BaseUriBuilder<MachineActivityReportParameters> implements UriBuilder<MachineActivityReportParameters> {

    public MachineActivityReportUriBuilder(CommonUriComponentsBuilder commonUriComponentsBuilder) {
        super(commonUriComponentsBuilder);
    }

    @Override
    protected UriComponentsBuilder addQueryParams(UriComponentsBuilder builder, MachineActivityReportParameters parameters) {
        return builder.queryParam("daysAgo", parameters.getDaysAgo());
    }

    @Override
    protected void addUriParams(Map<String, String> uriParams, MachineActivityReportParameters parameters) {
        uriParams.put("machine", parameters.getMachine());
    }

}
