package edu.ucar.cisl.hpctv.controller;

import edu.ucar.cisl.hpctv.report.machinelog.MachineLogReport;

public interface MachineLogReportQuery {

    MachineLogReportQuery daysAgo(Integer daysAgo);

    MachineLogReportQuery machine(String machine);

    MachineLogReport query();
}
