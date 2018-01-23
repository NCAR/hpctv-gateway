package edu.ucar.cisl.controller;

import edu.ucar.cisl.report.areaofinterestgrouplog.AreaOfInterestGroupLogReport;

public interface AreaOfInterestGroupLogReportQuery {

    AreaOfInterestGroupLogReportQuery machine(String machine);

    AreaOfInterestGroupLogReportQuery aoig(String aoig);

    AreaOfInterestGroupLogReportQuery daysAgo(Integer daysAgo);

    AreaOfInterestGroupLogReport query();

}
