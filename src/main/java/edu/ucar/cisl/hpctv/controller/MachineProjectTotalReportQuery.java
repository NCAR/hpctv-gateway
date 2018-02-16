package edu.ucar.cisl.hpctv.controller;

import edu.ucar.cisl.hpctv.report.machineprojecttotal.MachineProjectTotalReport;

public interface MachineProjectTotalReportQuery {

    MachineProjectTotalReportQuery machine(String machine);

    MachineProjectTotalReportQuery projcode(String projcode);

    MachineProjectTotalReport query();
}
