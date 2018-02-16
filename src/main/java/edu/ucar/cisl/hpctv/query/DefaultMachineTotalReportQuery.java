package edu.ucar.cisl.hpctv.query;

import edu.ucar.cisl.hpctv.controller.MachineTotalReportQuery;
import edu.ucar.cisl.hpctv.report.ReportExecutor;
import edu.ucar.cisl.hpctv.report.machinetotal.MachineTotalReportParameters;
import edu.ucar.cisl.hpctv.report.machinetotal.MachineTotalReport;

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
