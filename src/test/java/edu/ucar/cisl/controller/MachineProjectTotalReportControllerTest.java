package edu.ucar.cisl.controller;

import edu.ucar.cisl.config.Factory;
import edu.ucar.cisl.config.HpctvProps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MachineProjectTotalReportControllerTest {

    @Mock
    private Environment env;

    @Mock
    private MachineProjectTotalReportQuery query;

    @Mock
    private Factory<MachineProjectTotalReportQuery> queryFactory;

    @InjectMocks
    MachineProjectTotalReportController controller;

    @Test
    public void given_machine_and_projcode__when_getMachineProjectTotalReport__then_query_with_attributes() {
        when(env.getProperty(HpctvProps.SAM_MACHINE)).thenReturn("machine");
        when(queryFactory.create()).thenReturn(query);
        when(query.machine("machine")).thenReturn(query);
        when(query.projcode("SWEG0001")).thenReturn(query);

        controller.getMachineProjectTotalReport("SWEG0001");

        verify(query).query();
    }
}