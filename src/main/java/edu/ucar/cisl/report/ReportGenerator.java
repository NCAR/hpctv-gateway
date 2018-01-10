package edu.ucar.cisl.report;

public interface ReportGenerator<R,P> {

    R generate(P parameters);
}
