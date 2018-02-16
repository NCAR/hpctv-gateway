package edu.ucar.cisl.hpctv.query;

import edu.ucar.cisl.hpctv.report.ReportExecutor;
import edu.ucar.cisl.hpctv.report.machinetotal.MachineTotalReportParameters;
import edu.ucar.cisl.hpctv.report.machinetotal.MachineTotalReport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DefaultMachineTotalReportQueryTest {

    private static final String MACHINE = "machine";

    @Mock
    private ReportExecutor<MachineTotalReport, MachineTotalReportParameters> executor;

    @InjectMocks
    private DefaultMachineTotalReportQuery query;

    @Test
    public void given_machine__when_query__then_executor_called_with_parameter() {
        query.machine(MACHINE).query();
        assertExecutorExecutedWithParameters(MACHINE);
    }

    private void assertExecutorExecutedWithParameters(String machine) {
        ArgumentCaptor<MachineTotalReportParameters> captor = ArgumentCaptor.forClass(MachineTotalReportParameters.class);

        verify(executor).execute(captor.capture());

        MachineTotalReportParameters parameters = captor.getValue();
        assertThat(parameters.getMachine(), is(machine));
    }
}