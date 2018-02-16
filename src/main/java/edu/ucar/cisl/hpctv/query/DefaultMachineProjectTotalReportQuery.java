package edu.ucar.cisl.hpctv.query;

import edu.ucar.cisl.hpctv.controller.MachineProjectTotalReportQuery;
import edu.ucar.cisl.hpctv.report.ReportExecutor;
import edu.ucar.cisl.hpctv.report.machineprojecttotal.MachineProjectTotalReport;
import edu.ucar.cisl.hpctv.report.machineprojecttotal.MachineProjectTotalReportParameters;

public class DefaultMachineProjectTotalReportQuery implements MachineProjectTotalReportQuery, MachineProjectTotalReportParameters {

    private final ReportExecutor<MachineProjectTotalReport, MachineProjectTotalReportParameters> reportExecutor;

    private String machine;
    private String projcode;

    public DefaultMachineProjectTotalReportQuery(
            ReportExecutor<MachineProjectTotalReport, MachineProjectTotalReportParameters> reportExecutor) {
        this.reportExecutor = reportExecutor;
    }

    @Override
    public MachineProjectTotalReport query() {
        return reportExecutor.execute(this);
    }

    @Override
    public String getMachine() {
        return machine;
    }

    @Override
    public DefaultMachineProjectTotalReportQuery machine(String machine) {
        this.machine = machine;
        return this;
    }

    @Override
    public String getProjcode() {
        return projcode;
    }

    @Override
    public DefaultMachineProjectTotalReportQuery projcode(String projcode) {
        this.projcode = projcode;
        return this;
    }

    @Override
    public String toString() {
        return "DefaultMachineProjectTotalReportQuery{" +
                "machine='" + machine + '\'' +
                ", projcode='" + projcode + '\'' +
                '}';
    }
}
