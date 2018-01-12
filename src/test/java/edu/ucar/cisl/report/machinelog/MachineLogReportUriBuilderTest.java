package edu.ucar.cisl.report.machinelog;

import edu.ucar.cisl.report.CommonUriComponentsBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MachineLogReportUriBuilderTest {

    private MachineLogReportParameters parameters;
    private MachineLogReportUriBuilder builder;

    @Before
    public void setUp() throws Exception {
        parameters = mock(MachineLogReportParameters.class);
        when(parameters.getDaysAgo()).thenReturn(60);
        when(parameters.getMachine()).thenReturn("cheyenne");

        CommonUriComponentsBuilder commonUriComponentsBuilder = new CommonUriComponentsBuilder();
        commonUriComponentsBuilder.setScheme("https");
        commonUriComponentsBuilder.setHost("host.ucar.edu");

        builder = new MachineLogReportUriBuilder(commonUriComponentsBuilder);
        builder.setPath("/api/machine/{machine}");
    }

    @Test
    public void given_parameters__when_build__then_uri_correct() {
        assertThatBuilderUriMatches("https://host.ucar.edu/api/machine/cheyenne?daysAgo=60");
    }

    private void assertThatBuilderUriMatches(String uri) {
        assertThat(builder.build(parameters).toString(), is(uri));
    }
}