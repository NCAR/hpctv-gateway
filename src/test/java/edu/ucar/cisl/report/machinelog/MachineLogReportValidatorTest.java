package edu.ucar.cisl.report.machinelog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class MachineLogReportValidatorTest {

    @Mock
    private MachineLogReport report;

    @Mock
    private MachineLogReportParameters parameters;

    @InjectMocks
    private MachineLogReportValidator validator;

    @Test
    public void given_report__when_validate__then_true() {
        assertThat(validator.isValid(report, parameters), is(true));
    }
}