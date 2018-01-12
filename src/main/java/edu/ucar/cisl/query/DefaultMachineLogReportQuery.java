package edu.ucar.cisl.query;

import edu.ucar.cisl.controller.MachineLogReportQuery;
import edu.ucar.cisl.report.ReportExecutor;
import edu.ucar.cisl.report.machinelog.MachineLogReport;
import edu.ucar.cisl.report.machinelog.MachineLogReportParameters;

public class DefaultMachineLogReportQuery implements MachineLogReportQuery, MachineLogReportParameters {

    private final ReportExecutor<MachineLogReport, MachineLogReportParameters> executor;

    private String machine;
    private Integer daysAgo;

    public DefaultMachineLogReportQuery(
            ReportExecutor<MachineLogReport, MachineLogReportParameters> executor) {
        this.executor = executor;
    }

    @Override
    public MachineLogReport query() {
        return executor.execute(this);
    }

    @Override
    public String getMachine() {
        return machine;
    }

    @Override
    public DefaultMachineLogReportQuery machine(String machine) {
        this.machine = machine;
        return this;
    }

    @Override
    public Integer getDaysAgo() {
        return daysAgo;
    }

    @Override
    public DefaultMachineLogReportQuery daysAgo(Integer daysAgo) {
        this.daysAgo = daysAgo;
        return this;
    }

    @Override public String toString() {
        return "DefaultMachineLogReportQuery{" +
                "executor=" + executor +
                ", machine='" + machine + '\'' +
                ", daysAgo=" + daysAgo +
                '}';
    }
}
