package edu.ucar.cisl.query;

import edu.ucar.cisl.report.ReportExecutor;
import edu.ucar.cisl.report.machineactivity.MachineActivityReport;
import edu.ucar.cisl.report.machineactivity.MachineActivityReportParameters;
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
public class DefaultMachineActivityReportQueryTest {

    private static final String MACHINE = "machine";
    private static final int DAYS_AGO = 60;

    @Mock
    private ReportExecutor<MachineActivityReport, MachineActivityReportParameters> executor;

    @InjectMocks
    private DefaultMachineActivityReportQuery query;

    @Test
    public void given_machine_and_daysAgo__when_query__then_executor_called_with_parameters() {
        query.machine(MACHINE).daysAgo(DAYS_AGO).query();
        assertExecutorExecutedWithParameters(MACHINE, DAYS_AGO);
    }

    private void assertExecutorExecutedWithParameters(String machine, int daysAgo) {
        ArgumentCaptor<MachineActivityReportParameters> captor = ArgumentCaptor.forClass(MachineActivityReportParameters.class);

        verify(executor).execute(captor.capture());

        MachineActivityReportParameters parameters = captor.getValue();
        assertThat(parameters.getMachine(), is(machine));
        assertThat(parameters.getDaysAgo(), is(daysAgo));
    }
}