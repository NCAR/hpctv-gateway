package edu.ucar.cisl.report;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReportExecutorTest {

    @Mock
    private ReportGenerator<TestReport, TestParameters> generator;

    @Mock
    private ReportValidator<TestReport, TestParameters> validator;

    @InjectMocks
    private ReportExecutor<TestReport, TestParameters> executor;

    private TestReport testReport;
    private TestParameters testParameters;

    @Before
    public void setUp() throws Exception {
        testParameters = new TestParameters();
        testReport = new TestReport();
    }

    @Test
    public void given_parameters__when_execute__then_generate_and_validate() {
        when(generator.generate(testParameters)).thenReturn(testReport);
        when(validator.isValid(testReport, testParameters)).thenReturn(true);

        executor.execute(testParameters);

        verify(generator).generate(testParameters);
        verify(validator).isValid(testReport, testParameters);
    }

    @Test(expected = ReportGenerationException.class)
    public void given_generation_exception__when_execute__then_ReportGenerationException() {
        when(generator.generate(testParameters)).thenThrow(new RuntimeException());
        executor.execute(testParameters);
    }

    @Test(expected = InvalidReportException.class)
    public void given_invalid_report__when_execute__then_InvalidReportException() {
        when(generator.generate(testParameters)).thenReturn(testReport);
        when(validator.isValid(testReport, testParameters)).thenReturn(false);

        executor.execute(testParameters);
    }

    private class TestReport {

    }

    private class TestParameters {

    }
}