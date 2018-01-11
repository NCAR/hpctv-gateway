package edu.ucar.cisl.report;

public interface ReportValidator<R,P> {

    Boolean isValid(R report, P parameters);
}
