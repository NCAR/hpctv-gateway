package edu.ucar.cisl.hpctv.report.machineprojecttotal;

import edu.ucar.cisl.hpctv.report.CommonUriComponentsBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MachineProjectTotalReportUriBuilderTest {

    private MachineProjectTotalReportParameters parameters;
    private MachineProjectTotalReportUriBuilder builder;

    @Before
    public void setUp() throws Exception {
        parameters = mock(MachineProjectTotalReportParameters.class);
        when(parameters.getMachine()).thenReturn("cheyenne");
        when(parameters.getProjcode()).thenReturn("SWEG0001");

        CommonUriComponentsBuilder commonUriComponentsBuilder = new CommonUriComponentsBuilder();
        commonUriComponentsBuilder.setScheme("https");
        commonUriComponentsBuilder.setHost("host.ucar.edu");

        builder = new MachineProjectTotalReportUriBuilder(commonUriComponentsBuilder);
        builder.setPath("/api/machine/{machine}/project/{projcode}");
    }

    @Test
    public void given_parameters__when_build__then_uri_correct() {
        assertThatBuilderUriMatches("https://host.ucar.edu/api/machine/cheyenne/project/SWEG0001");
    }

    private void assertThatBuilderUriMatches(String uri) {
        assertThat(builder.build(parameters).toString(), is(uri));
    }
}