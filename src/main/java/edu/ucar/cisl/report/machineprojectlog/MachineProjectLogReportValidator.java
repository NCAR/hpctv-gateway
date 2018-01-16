package edu.ucar.cisl.report.machineprojectlog;

import edu.ucar.cisl.report.ReportValidator;

public class MachineProjectLogReportValidator implements ReportValidator<MachineProjectLogReport, MachineProjectLogReportParameters> {

    @Override
    public Boolean isValid(MachineProjectLogReport report, MachineProjectLogReportParameters parameters) {
        return !report.getEntries().isEmpty();
    }
}
