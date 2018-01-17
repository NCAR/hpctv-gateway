package edu.ucar.cisl.report.machineprojecttotal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class MachineProjectTotalReportValidatorTest {

    @Mock
    private MachineProjectTotalReport report;

    @Mock
    private MachineProjectTotalReportParameters parameters;

    @InjectMocks
    private MachineProjectTotalReportValidator validator;

    @Test
    public void given_report__when_validate__then_true() {
        assertThat(validator.isValid(report, parameters), is(true));
    }
}