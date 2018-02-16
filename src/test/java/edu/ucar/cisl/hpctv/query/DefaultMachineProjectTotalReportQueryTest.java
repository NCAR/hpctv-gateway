package edu.ucar.cisl.hpctv.query;

import edu.ucar.cisl.hpctv.report.ReportExecutor;
import edu.ucar.cisl.hpctv.report.machineprojecttotal.MachineProjectTotalReportParameters;
import edu.ucar.cisl.hpctv.report.machineprojecttotal.MachineProjectTotalReport;
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
public class DefaultMachineProjectTotalReportQueryTest {

    private static final String MACHINE = "machine";
    private static final String PROJCODE = "projcode";

    @Mock
    private ReportExecutor<MachineProjectTotalReport, MachineProjectTotalReportParameters> executor;

    @InjectMocks
    private DefaultMachineProjectTotalReportQuery query;


    @Test
    public void given_machine_and_projcode__when_query__then_executor_called_with_parameters() {
        query.machine(MACHINE).projcode(PROJCODE).query();
        assertExecutorExecutedWithParameters(MACHINE, PROJCODE);
    }

    private void assertExecutorExecutedWithParameters(String machine, String projcode) {
        ArgumentCaptor<MachineProjectTotalReportParameters> captor = ArgumentCaptor.forClass(MachineProjectTotalReportParameters.class);

        verify(executor).execute(captor.capture());

        MachineProjectTotalReportParameters parameters = captor.getValue();
        assertThat(parameters.getMachine(), is(machine));
        assertThat(parameters.getProjcode(), is(PROJCODE));
    }
}