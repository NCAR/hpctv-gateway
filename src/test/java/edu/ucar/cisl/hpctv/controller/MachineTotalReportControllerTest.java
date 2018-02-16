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
public class MachineTotalReportControllerTest {

    @Mock
    private Environment env;

    @Mock
    private MachineTotalReportQuery query;

    @Mock
    private Factory<MachineTotalReportQuery> queryFactory;

    @InjectMocks
    private MachineTotalReportController controller;

    @Test
    public void given_nothing__when_getMachineTotalReport__then_query_with_attributes() {
        when(env.getProperty(HpctvProps.SAM_MACHINE)).thenReturn("machine");
        when(queryFactory.create()).thenReturn(query);
        when(query.machine("machine")).thenReturn(query);

        controller.getMachineTotalReport();

        verify(query).query();
    }
}