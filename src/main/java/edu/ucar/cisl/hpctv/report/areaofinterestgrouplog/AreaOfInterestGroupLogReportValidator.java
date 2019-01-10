package edu.ucar.cisl.hpctv.report.areaofinterestgrouplog;

import edu.ucar.cisl.hpctv.report.ReportValidator;

import java.math.BigInteger;

public class AreaOfInterestGroupLogReportValidator implements ReportValidator<AreaOfInterestGroupLogReport, AreaOfInterestGroupLogReportParameters> {

    @Override
    public Boolean isValid(AreaOfInterestGroupLogReport report, AreaOfInterestGroupLogReportParameters parameters) {
        return isZeroOrMore(report.getProjects()) && isZeroOrMore(report.getJobs()) && isZeroOrMore(report.getCoreHours());
    }

    private Boolean isZeroOrMore(Integer i) {
        return !(i == null || i < 0);
    }

    private Boolean isZeroOrMore(BigInteger i) {
        return !(i == null || i.compareTo(new BigInteger("0")) < 0);
    }

}
