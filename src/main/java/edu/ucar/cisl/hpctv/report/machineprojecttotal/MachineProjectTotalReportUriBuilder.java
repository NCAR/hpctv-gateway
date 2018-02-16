package edu.ucar.cisl.hpctv.report.machineprojecttotal;

import edu.ucar.cisl.hpctv.report.BaseUriBuilder;
import edu.ucar.cisl.hpctv.report.CommonUriComponentsBuilder;
import edu.ucar.cisl.hpctv.report.UriBuilder;

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
