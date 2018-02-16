package edu.ucar.cisl.hpctv.query;

import edu.ucar.cisl.hpctv.controller.MachineLogReportQuery;
import edu.ucar.cisl.hpctv.report.machinelog.MachineLogReportParameters;
import edu.ucar.cisl.hpctv.report.ReportExecutor;
import edu.ucar.cisl.hpctv.report.machinelog.MachineLogReport;

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
                ", machine='" + machine + '\'' +
                ", daysAgo=" + daysAgo +
                '}';
    }
}
