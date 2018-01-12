package edu.ucar.cisl.query;

import edu.ucar.cisl.controller.MachineTotalReportQuery;
import edu.ucar.cisl.report.machinetotal.MachineTotalReport;
import edu.ucar.cisl.report.machinetotal.MachineTotalReportParameters;

public class DefaultMachineTotalReportQuery implements MachineTotalReportQuery, MachineTotalReportParameters{

    private String machine;

    @Override
    public MachineTotalReport query() {
        return null;
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
}
