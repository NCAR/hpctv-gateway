package edu.ucar.cisl.report.machinetotal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class MachineTotalReportValidatorTest {

    @Mock
    private MachineTotalReport report;

    @Mock
    private MachineTotalReportParameters parameters;

    @InjectMocks
    private MachineTotalReportValidator validator;

    @Test
    public void given_report__when_validate__then_true() {
        assertThat(validator.isValid(report, parameters), is(true));
    }
}