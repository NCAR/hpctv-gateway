package edu.ucar.cisl.report;

public class ReportExecutor<R, P> {

    private final ReportGenerator<R, P> generator;
    private final ReportValidator<R, P> validator;

    public ReportExecutor(ReportGenerator<R, P> generator, ReportValidator<R, P> validator) {
        this.generator = generator;
        this.validator = validator;
    }

    public R execute(P parameters) {
        return validateReport(tryGenerateReport(parameters), parameters);
    }

    private R tryGenerateReport(P parameters) {
        try {
            return generator.generate(parameters);
        } catch (Exception e) {
            throw new ReportGenerationException(parameters.toString(), e);
        }
    }

    private R validateReport(R report, P parameters) {
        if (!validator.isValid(report, parameters)) {
            throw new InvalidReportException(parameters.toString());
        }
        return report;
    }
}
