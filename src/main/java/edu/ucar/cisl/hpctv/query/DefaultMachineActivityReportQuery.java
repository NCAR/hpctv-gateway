package edu.ucar.cisl.hpctv.query;

import edu.ucar.cisl.hpctv.controller.MachineActivityReportQuery;
import edu.ucar.cisl.hpctv.report.ReportExecutor;
import edu.ucar.cisl.hpctv.report.machineactivity.MachineActivityReportParameters;
import edu.ucar.cisl.hpctv.report.machineactivity.MachineActivityReport;

public class DefaultMachineActivityReportQuery implements MachineActivityReportQuery, MachineActivityReportParameters {

    private final ReportExecutor<MachineActivityReport, MachineActivityReportParameters> executor;

    private String machine;
    private Integer daysAgo;

    public DefaultMachineActivityReportQuery(
            ReportExecutor<MachineActivityReport, MachineActivityReportParameters> executor) {
        this.executor = executor;
    }

    @Override
    public MachineActivityReport query() {
        return executor.execute(this);
    }

    @Override
    public String getMachine() {
        return machine;
    }

    @Override
    public DefaultMachineActivityReportQuery machine(String machine) {
        this.machine = machine;
        return this;
    }

    @Override
    public Integer getDaysAgo() {
        return daysAgo;
    }

    @Override
    public DefaultMachineActivityReportQuery daysAgo(Integer daysAgo) {
        this.daysAgo = daysAgo;
        return this;
    }

    @Override
    public String toString() {
        return "DefaultMachineActivityReportQuery{" +
                "machine='" + machine + '\'' +
                ", daysAgo=" + daysAgo +
                '}';
    }
}
