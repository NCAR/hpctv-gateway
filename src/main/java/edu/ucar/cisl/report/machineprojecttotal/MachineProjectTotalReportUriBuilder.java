package edu.ucar.cisl.report.machineprojecttotal;

import edu.ucar.cisl.report.BaseUriBuilder;
import edu.ucar.cisl.report.CommonUriComponentsBuilder;
import edu.ucar.cisl.report.UriBuilder;

import java.util.Map;

public class MachineProjectTotalReportUriBuilder extends BaseUriBuilder<MachineProjectTotalReportParameters> implements UriBuilder<MachineProjectTotalReportParameters> {

    public MachineProjectTotalReportUriBuilder(CommonUriComponentsBuilder commonUriComponentsBuilder) {
        super(commonUriComponentsBuilder);
    }

    @Override
    protected void addUriParams(Map<String, String> uriParams, MachineProjectTotalReportParameters parameters) {
        uriParams.put("machine", parameters.getMachine());
        uriParams.put("projcode", parameters.getProjcode());
    }
}
