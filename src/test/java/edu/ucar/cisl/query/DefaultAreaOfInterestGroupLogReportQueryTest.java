package edu.ucar.cisl.query;

import edu.ucar.cisl.report.ReportExecutor;
import edu.ucar.cisl.report.areaofinterestgrouplog.AreaOfInterestGroupLogReport;
import edu.ucar.cisl.report.areaofinterestgrouplog.AreaOfInterestGroupLogReportParameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DefaultAreaOfInterestGroupLogReportQueryTest {

    private static final String MACHINE = "machine";

    private static final int DAYS_AGO = 60;

    private static final String AOIG = "aoig";

    @Mock
    private ReportExecutor<AreaOfInterestGroupLogReport, AreaOfInterestGroupLogReportParameters> executor;

    @InjectMocks
    private DefaultAreaOfInterestGroupLogReportQuery query;

    @Test
    public void given_machine_daysAgo_and_Aoig__when_query__then_executor_called_with_parameters() {
        query.machine(MACHINE).daysAgo(DAYS_AGO).aoig(AOIG).query();
        assertExecutorExecutedWithParameters(MACHINE, DAYS_AGO, AOIG);
    }

    private void assertExecutorExecutedWithParameters(String machine, int daysAgo, String aoig) {
        ArgumentCaptor<AreaOfInterestGroupLogReportParameters> captor = ArgumentCaptor.forClass(AreaOfInterestGroupLogReportParameters.class);

        verify(executor).execute(captor.capture());

        AreaOfInterestGroupLogReportParameters parameters = captor.getValue();
        assertThat(parameters.getMachine(), is(machine));
        assertThat(parameters.getDaysAgo(), is(daysAgo));
        assertThat(parameters.getAoig(), is(aoig));
    }

}