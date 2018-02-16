package edu.ucar.cisl.hpctv.report.machineprojectlog;

import edu.ucar.cisl.hpctv.report.ReportValidator;

public class MachineProjectLogReportValidator implements ReportValidator<MachineProjectLogReport, MachineProjectLogReportParameters> {

    @Override
    public Boolean isValid(MachineProjectLogReport report, MachineProjectLogReportParameters parameters) {
        return !report.getEntries().isEmpty();
    }
}
