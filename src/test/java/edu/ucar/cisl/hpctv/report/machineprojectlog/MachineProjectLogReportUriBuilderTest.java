package edu.ucar.cisl.hpctv.report.machineprojectlog;

import edu.ucar.cisl.hpctv.report.CommonUriComponentsBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MachineProjectLogReportUriBuilderTest {

    private MachineProjectLogReportParameters parameters;
    private MachineProjectLogReportUriBuilder builder;

    @Before
    public void setUp() throws Exception {
        parameters = mock(MachineProjectLogReportParameters.class);
        when(parameters.getDaysAgo()).thenReturn(60);
        when(parameters.getMachine()).thenReturn("cheyenne");

        CommonUriComponentsBuilder commonUriComponentsBuilder = new CommonUriComponentsBuilder();
        commonUriComponentsBuilder.setScheme("https");
        commonUriComponentsBuilder.setHost("host.ucar.edu");

        builder = new MachineProjectLogReportUriBuilder(commonUriComponentsBuilder);
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