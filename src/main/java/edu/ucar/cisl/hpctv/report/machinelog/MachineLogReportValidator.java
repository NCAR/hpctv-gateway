package edu.ucar.cisl.hpctv.report.machinelog;

import edu.ucar.cisl.hpctv.report.ReportValidator;

import java.math.BigInteger;

public class MachineLogReportValidator implements ReportValidator<MachineLogReport, MachineLogReportParameters> {

    @Override
    public Boolean isValid(MachineLogReport report, MachineLogReportParameters parameters) {
        return isCount(report.getProjects()) && isCount(report.getJobs()) && isCount(report.getCoreHours());
    }

    private Boolean isCount(Integer i) {
        return !(i == null || i <= 0);
    }

    private Boolean isCount(BigInteger i) {
        return !(i == null || i.compareTo(new BigInteger("0")) <= 0);
    }
}
