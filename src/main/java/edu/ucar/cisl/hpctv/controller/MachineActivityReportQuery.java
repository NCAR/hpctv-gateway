package edu.ucar.cisl.hpctv.controller;

import edu.ucar.cisl.hpctv.report.machineactivity.MachineActivityReport;

public interface MachineActivityReportQuery {

    MachineActivityReportQuery daysAgo(Integer daysAgo);

    MachineActivityReportQuery machine(String machine);

    MachineActivityReport query();
}
