package edu.ucar.cisl.report.machineactivity;

import edu.ucar.cisl.controller.MachineActivityReportQuery;
import edu.ucar.cisl.report.ReportGenerator;

public class DefaultMachineActivityReportQuery implements MachineActivityReportQuery, MachineActivityReportParameters {

    private final ReportGenerator<MachineActivityReport, MachineActivityReportParameters> generator;

    private String machine;
    private Integer daysAgo;

    public DefaultMachineActivityReportQuery(ReportGenerator generator) {
        this.generator = generator;
    }

    @Override
    public MachineActivityReport query() {
        return generator.generate(this);
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
}
