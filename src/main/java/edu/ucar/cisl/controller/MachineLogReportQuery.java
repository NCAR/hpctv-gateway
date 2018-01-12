package edu.ucar.cisl.controller;

import edu.ucar.cisl.report.machinelog.MachineLogReport;

public interface MachineLogReportQuery {

    MachineLogReportQuery daysAgo(Integer daysAgo);

    MachineLogReportQuery machine(String machine);

    MachineLogReport query();
}
