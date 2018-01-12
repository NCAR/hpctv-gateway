package edu.ucar.cisl.controller;

import edu.ucar.cisl.config.Factory;
import edu.ucar.cisl.config.HpctvProps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MachineLogReportControllerTest {

    @Mock
    private Environment env;

    @Mock
    private MachineLogReportQuery query;

    @Mock
    private Factory<MachineLogReportQuery> queryFactory;

    @InjectMocks
    private MachineLogReportController controller;

    @Test
    public void given_daysAgo__when_getMachineActivityReport__then_query_with_attributes() {
        when(env.getProperty(HpctvProps.SAM_MACHINE)).thenReturn("machine");
        when(queryFactory.create()).thenReturn(query);
        when(query.machine(anyString())).thenReturn(query);
        when(query.daysAgo(60)).thenReturn(query);

        controller.getMachineLogReport(60);

        verify(query).query();
    }
}