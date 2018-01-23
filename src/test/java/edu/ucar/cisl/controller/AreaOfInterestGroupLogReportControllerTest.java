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
public class AreaOfInterestGroupLogReportControllerTest {

    private static final String MACHINE = "machine";

    private static final Integer DAYS_AGO = 60;

    private static final String AOIG = "aoig";

    @Mock
    private Environment env;

    @Mock
    private AreaOfInterestGroupLogReportQuery query;

    @Mock
    private Factory<AreaOfInterestGroupLogReportQuery> queryFactory;

    @InjectMocks
    private AreaOfInterestGroupLogReportController controller;

    @Test
    public void given_daysAgo__when_getAreaOfInterestGroupLogReport__then_query_with_attributes() {
        when(env.getProperty(HpctvProps.SAM_MACHINE)).thenReturn(MACHINE);
        when(queryFactory.create()).thenReturn(query);
        when(query.machine(MACHINE)).thenReturn(query);
        when(query.aoig(AOIG)).thenReturn(query);
        when(query.daysAgo(DAYS_AGO)).thenReturn(query);

        controller.getAreaOfInterestGroupLogReport(AOIG, DAYS_AGO);

        verify(query).query();
    }
}