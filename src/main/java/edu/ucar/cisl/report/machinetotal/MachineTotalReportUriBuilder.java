package edu.ucar.cisl.report.machinetotal;

import edu.ucar.cisl.report.BaseUriBuilder;
import edu.ucar.cisl.report.CommonUriComponentsBuilder;
import edu.ucar.cisl.report.UriBuilder;

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
