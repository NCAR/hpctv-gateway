package edu.ucar.cisl.hpctv.query;

import edu.ucar.cisl.hpctv.report.ReportExecutor;
import edu.ucar.cisl.hpctv.report.machinelog.MachineLogReportParameters;
import edu.ucar.cisl.hpctv.report.machinelog.MachineLogReport;
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
public class DefaultMachineLogReportQueryTest {

    private static final String MACHINE = "machine";
    private static final int DAYS_AGO = 60;

    @Mock
    private ReportExecutor<MachineLogReport, MachineLogReportParameters> executor;

    @InjectMocks
    private DefaultMachineLogReportQuery query;

    @Test
    public void given_machine_and_daysAgo__when_query__then_executor_called_with_parameters() {
        query.machine(MACHINE).daysAgo(DAYS_AGO).query();
        assertExecutorExecutedWithParameters(MACHINE, DAYS_AGO);
    }

    private void assertExecutorExecutedWithParameters(String machine, int daysAgo) {
        ArgumentCaptor<MachineLogReportParameters> captor = ArgumentCaptor.forClass(MachineLogReportParameters.class);

        verify(executor).execute(captor.capture());

        MachineLogReportParameters parameters = captor.getValue();
        assertThat(parameters.getMachine(), is(machine));
        assertThat(parameters.getDaysAgo(), is(daysAgo));
    }
}