package edu.ucar.cisl.hpctv.report.machineprojecttotal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class MachineProjectTotalReportValidatorTest {

    private MachineProjectTotalReport report;

    @Mock
    private MachineProjectTotalReportParameters parameters;

    @InjectMocks
    private MachineProjectTotalReportValidator validator;

    @Before
    public void setUp() throws Exception {
        report = new MachineProjectTotalReport();
        report.setJobs(1);
        report.setCoreHours(new BigInteger("1"));
    }

    @Test
    public void given_report__when_validate__then_true_if_all_counts_greater_than_zero() {
        assertValidReport();
    }

    @Test
    public void given_report__when_validate__then_false_if_jobs_count_null() {
        report.setJobs(null);
        assertInvalidReport();
    }

    @Test
    public void given_report__when_validate__then_false_if_jobs_count_zero() {
        report.setJobs(0);
        assertInvalidReport();
    }

    @Test
    public void given_report__when_validate__then_false_if_jobs_count_less_than_zero() {
        report.setJobs(-1);
        assertInvalidReport();
    }

    @Test
    public void given_report__when_validate__then_false_if_coreHours_count_null() {
        report.setCoreHours(null);
        assertInvalidReport();
    }

    @Test
    public void given_report__when_validate__then_false_if_coreHours_count_zero() {
        report.setCoreHours(new BigInteger("0"));
        assertInvalidReport();
    }

    @Test
    public void given_report__when_validate__then_false_if_coreHours_count_less_than_zero() {
        report.setCoreHours(new BigInteger("-1"));
        assertInvalidReport();
    }

    private void assertInvalidReport() {
        assertThat(validator.isValid(report, parameters), is(false));
    }

    private void assertValidReport() {
        assertThat(validator.isValid(report, parameters), is(true));
    }
}