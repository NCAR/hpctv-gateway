package edu.ucar.cisl.report.areaofinterestgrouplog;

import edu.ucar.cisl.report.ReportValidator;

import java.math.BigInteger;

public class AreaOfInterestGroupLogReportValidator implements ReportValidator<AreaOfInterestGroupLogReport, AreaOfInterestGroupLogReportParameters> {

    @Override
    public Boolean isValid(AreaOfInterestGroupLogReport report, AreaOfInterestGroupLogReportParameters parameters) {
        return isCount(report.getProjects()) && isCount(report.getJobs()) && isCount(report.getCoreHours());
    }

    private Boolean isCount(Integer i) {
        return !(i == null || i <= 0);
    }

    private Boolean isCount(BigInteger i) {
        return !(i == null || i.compareTo(new BigInteger("0")) <= 0);
    }

}
