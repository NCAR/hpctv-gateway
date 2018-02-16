package edu.ucar.cisl.hpctv.report.areaofinterestgrouplog;

import edu.ucar.cisl.hpctv.report.BaseUriBuilder;
import edu.ucar.cisl.hpctv.report.UriBuilder;
import edu.ucar.cisl.hpctv.report.CommonUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class AreaOfInterestGroupLogReportUriBuilder extends BaseUriBuilder<AreaOfInterestGroupLogReportParameters> implements UriBuilder<AreaOfInterestGroupLogReportParameters> {

    public AreaOfInterestGroupLogReportUriBuilder(CommonUriComponentsBuilder commonUriComponentsBuilder) {
        super(commonUriComponentsBuilder);
    }

    @Override
    protected UriComponentsBuilder addQueryParams(UriComponentsBuilder builder, AreaOfInterestGroupLogReportParameters parameters) {
        return builder.queryParam("daysAgo", parameters.getDaysAgo());
    }

    @Override
    protected void addUriParams(Map<String, String> uriParams, AreaOfInterestGroupLogReportParameters parameters) {
        uriParams.put("machine", parameters.getMachine());
        uriParams.put("aoig", parameters.getAoig());
    }

}
