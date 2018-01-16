package edu.ucar.cisl.controller;

import edu.ucar.cisl.report.machineprojectlog.MachineProjectLogReport;

public interface MachineProjectLogReportQuery {

    MachineProjectLogReportQuery daysAgo(Integer daysAgo);

    MachineProjectLogReportQuery machine(String machine);

    MachineProjectLogReport query();
}
