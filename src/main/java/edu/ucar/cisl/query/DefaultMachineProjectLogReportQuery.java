package edu.ucar.cisl.query;

import edu.ucar.cisl.controller.MachineProjectLogReportQuery;
import edu.ucar.cisl.report.ReportExecutor;
import edu.ucar.cisl.report.machineprojectlog.MachineProjectLogReportParameters;
import edu.ucar.cisl.report.machineprojectlog.MachineProjectLogReport;

public class DefaultMachineProjectLogReportQuery implements MachineProjectLogReportQuery, MachineProjectLogReportParameters {

    private final ReportExecutor<MachineProjectLogReport, MachineProjectLogReportParameters> reportExecutor;

    private String machine;
    private Integer daysAgo;

    public DefaultMachineProjectLogReportQuery(
            ReportExecutor<MachineProjectLogReport, MachineProjectLogReportParameters> reportExecutor) {
        this.reportExecutor = reportExecutor;
    }

    @Override
    public MachineProjectLogReport query() {
        return reportExecutor.execute(this);
    }

    @Override
    public String getMachine() {
        return machine;
    }

    @Override
    public DefaultMachineProjectLogReportQuery machine(String machine) {
        this.machine = machine;
        return this;
    }

    @Override
    public Integer getDaysAgo() {
        return daysAgo;
    }

    @Override
    public DefaultMachineProjectLogReportQuery daysAgo(Integer daysAgo) {
        this.daysAgo = daysAgo;
        return this;
    }

    @Override
    public String toString() {
        return "DefaultMachineProjectLogReportQuery{" +
                "machine='" + machine + '\'' +
                ", daysAgo=" + daysAgo +
                '}';
    }
}
