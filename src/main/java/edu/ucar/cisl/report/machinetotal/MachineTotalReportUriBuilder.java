package edu.ucar.cisl.report.machinetotal;

import edu.ucar.cisl.report.AbstractUriBuilder;
import edu.ucar.cisl.report.CommonUriComponentsBuilder;
import edu.ucar.cisl.report.UriBuilder;
import edu.ucar.cisl.report.machineactivity.MachineActivityReportParameters;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class MachineTotalReportUriBuilder extends AbstractUriBuilder<MachineTotalReportParameters> implements UriBuilder<MachineTotalReportParameters> {

    public MachineTotalReportUriBuilder(CommonUriComponentsBuilder commonUriComponentsBuilder) {
        super(commonUriComponentsBuilder);
    }

    @Override
    protected void addUriParams(Map<String, String> uriParams, MachineTotalReportParameters parameters) {
        uriParams.put("machine", parameters.getMachine());
    }
}
