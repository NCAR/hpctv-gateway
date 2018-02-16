package edu.ucar.cisl.hpctv.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportExecutor<R, P> {

    private static final Logger LOG = LoggerFactory.getLogger(ReportExecutor.class);

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
            LOG.debug("Generating report, parameters {}", parameters);
            return generator.generate(parameters);
        } catch (Exception e) {
            LOG.error("Failed to generate report, parameters {}:", parameters, e);
            throw new ReportGenerationException(parameters.toString(), e);
        }
    }

    private R validateReport(R report, P parameters) {
        if (!validator.isValid(report, parameters)) {
            LOG.error("Failed to validate report, parameters {}", parameters);
            throw new InvalidReportException(parameters.toString());
        }
        LOG.debug("Validated report, parameters {}", parameters);
        return report;
    }
}
