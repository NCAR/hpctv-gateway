package edu.ucar.cisl.hpctv.report.machineprojecttotal;

import edu.ucar.cisl.hpctv.report.ReportValidator;

import java.math.BigInteger;

public class MachineProjectTotalReportValidator implements ReportValidator<MachineProjectTotalReport, MachineProjectTotalReportParameters> {

    @Override
    public Boolean isValid(MachineProjectTotalReport report, MachineProjectTotalReportParameters parameters) {
        return isCount(report.getJobs()) && isCount(report.getCoreHours());
    }

    private Boolean isCount(Integer i) {
        return !(i == null || i <= 0);
    }

    private Boolean isCount(BigInteger i) {
        return !(i == null || i.compareTo(new BigInteger("0")) <= 0);
    }

}
