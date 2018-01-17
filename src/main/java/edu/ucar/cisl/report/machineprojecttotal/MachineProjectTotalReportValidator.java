package edu.ucar.cisl.report.machineprojecttotal;

import edu.ucar.cisl.report.ReportValidator;

public class MachineProjectTotalReportValidator implements ReportValidator<MachineProjectTotalReport, MachineProjectTotalReportParameters> {

    @Override
    public Boolean isValid(MachineProjectTotalReport report, MachineProjectTotalReportParameters parameters) {
        return true;
    }
}
