package edu.ucar.cisl.hpctv.report.machineactivity;

import edu.ucar.cisl.hpctv.report.BaseUriBuilder;
import edu.ucar.cisl.hpctv.report.CommonUriComponentsBuilder;
import edu.ucar.cisl.hpctv.report.UriBuilder;
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
