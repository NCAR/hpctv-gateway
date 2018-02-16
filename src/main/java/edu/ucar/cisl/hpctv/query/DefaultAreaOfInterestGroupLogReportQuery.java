package edu.ucar.cisl.hpctv.query;

import edu.ucar.cisl.hpctv.controller.AreaOfInterestGroupLogReportQuery;
import edu.ucar.cisl.hpctv.report.ReportExecutor;
import edu.ucar.cisl.hpctv.report.areaofinterestgrouplog.AreaOfInterestGroupLogReport;
import edu.ucar.cisl.hpctv.report.areaofinterestgrouplog.AreaOfInterestGroupLogReportParameters;

public class DefaultAreaOfInterestGroupLogReportQuery implements AreaOfInterestGroupLogReportQuery, AreaOfInterestGroupLogReportParameters {

    private String machine;

    private String aoig;

    private Integer daysAgo;

    private final ReportExecutor<AreaOfInterestGroupLogReport, AreaOfInterestGroupLogReportParameters> executor;

    public DefaultAreaOfInterestGroupLogReportQuery(
            ReportExecutor<AreaOfInterestGroupLogReport, AreaOfInterestGroupLogReportParameters> executor) {
        this.executor = executor;
    }

    @Override
    public AreaOfInterestGroupLogReport query() {
        return executor.execute(this);
    }

    @Override
    public String getMachine() {
        return machine;
    }

    @Override
    public DefaultAreaOfInterestGroupLogReportQuery machine(String machine) {
        this.machine = machine;
        return this;
    }

    @Override
    public String getAoig() {
        return this.aoig;
    }

    @Override
    public DefaultAreaOfInterestGroupLogReportQuery aoig(String aoig) {
        this.aoig = aoig;
        return this;
    }

    @Override
    public Integer getDaysAgo() {
        return daysAgo;
    }

    @Override
    public DefaultAreaOfInterestGroupLogReportQuery daysAgo(Integer daysAgo) {
        this.daysAgo = daysAgo;
        return this;
    }

    @Override
    public String toString() {
        return "DefaultAreaOfInterestGroupLogReportQuery {" +
                "machine='" + machine + '\'' +
                ", aoig='" + aoig + '\'' +
                ", daysAgo=" + daysAgo +
                '}';
    }

}
