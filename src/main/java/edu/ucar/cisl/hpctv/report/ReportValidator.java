package edu.ucar.cisl.hpctv.report;

public interface ReportValidator<R,P> {

    Boolean isValid(R report, P parameters);
}
