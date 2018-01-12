package edu.ucar.cisl.controller;

import edu.ucar.cisl.report.machinetotal.MachineTotalReport;

public interface MachineTotalReportQuery {

    MachineTotalReportQuery machine(String machine);

    MachineTotalReport query();
}
