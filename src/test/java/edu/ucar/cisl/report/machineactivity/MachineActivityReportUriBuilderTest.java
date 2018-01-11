package edu.ucar.cisl.report.machineactivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MachineActivityReportUriBuilderTest {

    @Mock
    private MachineActivityReportParameters parameters;

    @InjectMocks
    private MachineActivityReportUriBuilder builder;

    @Before
    public void setUp() throws Exception {
        when(parameters.getDaysAgo()).thenReturn(60);
        when(parameters.getMachine()).thenReturn("cheyenne");

        builder.setHost("host.ucar.edu");
        builder.setPath("/api/machine/{machine}");
    }

    @Test
    public void given_https_and_no_port__when_build__then_uri_correct() {
        builder.setScheme("https");
        assertThatBuilderUriMatches("https://host.ucar.edu/api/machine/cheyenne?daysAgo=60");
    }

    @Test
    public void given_https_and_port__when_build__then_uri_correct() {
        builder.setScheme("https");
        builder.setPort("8443");
        assertThatBuilderUriMatches("https://host.ucar.edu:8443/api/machine/cheyenne?daysAgo=60");
    }

    @Test
    public void given_http_and_no_port__when_build__then_uri_correct() {
        builder.setScheme("http");
        assertThatBuilderUriMatches("http://host.ucar.edu/api/machine/cheyenne?daysAgo=60");
    }

    @Test
    public void given_http_and_port__when_build__then_uri_correct() {
        builder.setScheme("http");
        builder.setPort("8080");
        assertThatBuilderUriMatches("http://host.ucar.edu:8080/api/machine/cheyenne?daysAgo=60");
    }

    private void assertThatBuilderUriMatches(String uri) {
        assertThat(builder.build(parameters).toString(), is(uri));
    }
}