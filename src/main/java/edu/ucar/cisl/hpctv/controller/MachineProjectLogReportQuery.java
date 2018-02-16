package edu.ucar.cisl.hpctv.controller;

import edu.ucar.cisl.hpctv.report.machineprojectlog.MachineProjectLogReport;

public interface MachineProjectLogReportQuery {

    MachineProjectLogReportQuery daysAgo(Integer daysAgo);

    MachineProjectLogReportQuery machine(String machine);

    MachineProjectLogReport query();
}
