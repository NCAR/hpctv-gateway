package edu.ucar.cisl.hpctv.controller;

import edu.ucar.cisl.hpctv.report.areaofinterestgrouplog.AreaOfInterestGroupLogReport;

public interface AreaOfInterestGroupLogReportQuery {

    AreaOfInterestGroupLogReportQuery machine(String machine);

    AreaOfInterestGroupLogReportQuery aoig(String aoig);

    AreaOfInterestGroupLogReportQuery daysAgo(Integer daysAgo);

    AreaOfInterestGroupLogReport query();

}
