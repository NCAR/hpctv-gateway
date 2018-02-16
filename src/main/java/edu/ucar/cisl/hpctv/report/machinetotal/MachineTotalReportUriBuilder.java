package edu.ucar.cisl.hpctv.report.machinetotal;

import edu.ucar.cisl.hpctv.report.BaseUriBuilder;
import edu.ucar.cisl.hpctv.report.CommonUriComponentsBuilder;
import edu.ucar.cisl.hpctv.report.UriBuilder;

import java.util.Map;

public class MachineTotalReportUriBuilder extends BaseUriBuilder<MachineTotalReportParameters> implements UriBuilder<MachineTotalReportParameters> {

    public MachineTotalReportUriBuilder(CommonUriComponentsBuilder commonUriComponentsBuilder) {
        super(commonUriComponentsBuilder);
    }

    @Override
    protected void addUriParams(Map<String, String> uriParams, MachineTotalReportParameters parameters) {
        uriParams.put("machine", parameters.getMachine());
    }
}
