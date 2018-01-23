package edu.ucar.cisl.report.areaofinterestgrouplog;

import edu.ucar.cisl.report.CommonUriComponentsBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AreaOfInterestGroupLogReportUriBuilderTest {

    private static final String HOST = "host.ucar.edu";
    private AreaOfInterestGroupLogReportParameters parameters;

    private AreaOfInterestGroupLogReportUriBuilder builder;

    private static final String PROTOCOL = "https";

    private static final String AOIG = "Paleoclimate";

    private static final Integer DAYS_AGO = 60;

    private static final String MACHINE = "cheyenne";

    @Before
    public void setUp() {
        parameters = mock(AreaOfInterestGroupLogReportParameters.class);
        when(parameters.getAoig()).thenReturn(AOIG);
        when(parameters.getDaysAgo()).thenReturn(DAYS_AGO);
        when(parameters.getMachine()).thenReturn(MACHINE);

        CommonUriComponentsBuilder commonUriComponentsBuilder = new CommonUriComponentsBuilder();
        commonUriComponentsBuilder.setScheme(PROTOCOL);
        commonUriComponentsBuilder.setHost(HOST);

        builder = new AreaOfInterestGroupLogReportUriBuilder(commonUriComponentsBuilder);
        builder.setPath("/api/machine/{machine}/aoig/{aoig}");
    }

    @Test
    public void given_parameters__when_build__then_uri_correct() {
        assertThatBuilderUriMatches(String.format("%s://%s/api/machine/%s/aoig/%s?daysAgo=%d", PROTOCOL, HOST, MACHINE, AOIG, DAYS_AGO));
    }

    @Test
    public void given_parameters_with_space_in_aoig__when_build__then_uri_correct() {
        String aoig = "Weather Prediction";
        String aoigHtmlEscaped = "Weather%20Prediction";

        when(parameters.getAoig()).thenReturn(aoig);

        assertThatBuilderUriMatches(String.format("%s://%s/api/machine/%s/aoig/%s?daysAgo=%d", PROTOCOL, HOST, MACHINE, aoigHtmlEscaped, DAYS_AGO));
    }

    private void assertThatBuilderUriMatches(String uri) {
        assertThat(builder.build(parameters).toString(), is(uri));
    }

}