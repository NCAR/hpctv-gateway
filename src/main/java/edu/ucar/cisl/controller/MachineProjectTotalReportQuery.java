package edu.ucar.cisl.controller;

import edu.ucar.cisl.report.machineprojecttotal.MachineProjectTotalReport;

public interface MachineProjectTotalReportQuery {

    MachineProjectTotalReportQuery machine(String machine);

    MachineProjectTotalReportQuery projcode(String projcode);

    MachineProjectTotalReport query();
}
