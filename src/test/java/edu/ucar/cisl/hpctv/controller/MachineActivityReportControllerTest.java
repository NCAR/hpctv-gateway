package edu.ucar.cisl.hpctv.controller;

import edu.ucar.cisl.hpctv.config.Factory;
import edu.ucar.cisl.hpctv.config.HpctvProps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MachineActivityReportControllerTest {

    @Mock
    private Environment env;

    @Mock
    private MachineActivityReportQuery query;

    @Mock
    private Factory<MachineActivityReportQuery> queryFactory;

    @InjectMocks
    private MachineActivityReportController controller;

    @Test
    public void given_daysAgo__when_getMachineActivityReport__then_query_with_attributes() {
        when(env.getProperty(HpctvProps.SAM_MACHINE)).thenReturn("machine");
        when(queryFactory.create()).thenReturn(query);
        when(query.machine("machine")).thenReturn(query);
        when(query.daysAgo(60)).thenReturn(query);

        controller.getMachineActivityReport(60);

        verify(query).query();
    }
}