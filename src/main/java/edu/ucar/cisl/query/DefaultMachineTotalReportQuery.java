package edu.ucar.cisl.query;

import edu.ucar.cisl.controller.MachineTotalReportQuery;
import edu.ucar.cisl.report.ReportExecutor;
import edu.ucar.cisl.report.machinetotal.MachineTotalReport;
import edu.ucar.cisl.report.machinetotal.MachineTotalReportParameters;

public class DefaultMachineTotalReportQuery implements MachineTotalReportQuery, MachineTotalReportParameters {

    private final ReportExecutor<MachineTotalReport, MachineTotalReportParameters> executor;

    private String machine;

    public DefaultMachineTotalReportQuery(
            ReportExecutor<MachineTotalReport, MachineTotalReportParameters> executor) {
        this.executor = executor;
    }

    @Override
    public MachineTotalReport query() {
        return executor.execute(this);
    }

    @Override
    public String getMachine() {
        return machine;
    }

    @Override
    public DefaultMachineTotalReportQuery machine(String machine) {
        this.machine = machine;
        return this;
    }

    @Override
    public String toString() {
        return "DefaultMachineTotalReportQuery{" +
                "machine='" + machine + '\'' +
                '}';
    }
}
