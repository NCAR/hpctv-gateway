package edu.ucar.cisl.hpctv.report;

public interface ReportGenerator<R,P> {

    R generate(P parameters);
}
