package edu.ucar.cisl.report.machinelog;

import edu.ucar.cisl.report.ReportValidator;
import edu.ucar.cisl.report.machineactivity.MachineActivityReport;
import edu.ucar.cisl.report.machineactivity.MachineActivityReportParameters;

public class MachineLogReportValidator implements ReportValidator<MachineLogReport, MachineLogReportParameters> {

    @Override
    public Boolean isValid(MachineLogReport report, MachineLogReportParameters parameters) {
        return true;
    }

}
