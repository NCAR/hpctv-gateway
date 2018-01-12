package edu.ucar.cisl.report.machinetotal;

import edu.ucar.cisl.report.ReportValidator;
import edu.ucar.cisl.report.machineactivity.MachineActivityReport;
import edu.ucar.cisl.report.machineactivity.MachineActivityReportParameters;

public class MachineTotalReportValidator implements ReportValidator<MachineTotalReport, MachineTotalReportParameters> {

    @Override
    public Boolean isValid(MachineTotalReport report, MachineTotalReportParameters parameters) {
        return true;
    }

}
