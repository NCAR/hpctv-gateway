package edu.ucar.cisl.controller;

import edu.ucar.cisl.report.machineactivity.MachineActivityReport;

public interface MachineActivityReportQuery {

    MachineActivityReportQuery daysAgo(Integer daysAgo);

    MachineActivityReportQuery machine(String machine);

    MachineActivityReport query();
}
