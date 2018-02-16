package edu.ucar.cisl.hpctv.report.machinelog;

import edu.ucar.cisl.hpctv.report.BaseUriBuilder;
import edu.ucar.cisl.hpctv.report.UriBuilder;
import edu.ucar.cisl.hpctv.report.CommonUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class MachineLogReportUriBuilder extends BaseUriBuilder<MachineLogReportParameters> implements UriBuilder<MachineLogReportParameters> {

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
