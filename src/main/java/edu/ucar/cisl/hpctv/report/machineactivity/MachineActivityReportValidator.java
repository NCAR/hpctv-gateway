package edu.ucar.cisl.hpctv.report.machineactivity;

import edu.ucar.cisl.hpctv.report.ReportValidator;

public class MachineActivityReportValidator implements ReportValidator<MachineActivityReport, MachineActivityReportParameters> {

    @Override
    public Boolean isValid(MachineActivityReport report, MachineActivityReportParameters parameters) {
        return !report.getEntries().isEmpty();
    }

}
