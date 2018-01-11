package edu.ucar.cisl.controller;

import edu.ucar.cisl.config.Factory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MachineActivityReportControllerTest {

    @Mock
    private MachineActivityReportQuery query;

    @Mock
    private Factory<MachineActivityReportQuery> queryFactory;

    @InjectMocks
    private MachineActivityReportController controller;

    @Test
    public void given_daysAgo__when_getMachineActivityReport__then_query_with_attributes() {
        when(queryFactory.create()).thenReturn(query);
        when(query.machine(anyString())).thenReturn(query);
        when(query.daysAgo(60)).thenReturn(query);

        controller.getMachineActivityReport(60);

        verify(query).query();
    }
}