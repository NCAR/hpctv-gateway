package edu.ucar.cisl.hpctv.controller;

import edu.ucar.cisl.hpctv.report.machinetotal.MachineTotalReport;

public interface MachineTotalReportQuery {

    MachineTotalReportQuery machine(String machine);

    MachineTotalReport query();
}
