package edu.ucar.cisl.hpctv.report;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RestTemplateReportGeneratorTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private UriBuilder<TestParameters> uriBuilder;

    @Mock
    private ReportClassSupplier<TestReport> reportReportClassSupplier;

    @InjectMocks
    private RestTemplateReportGenerator<TestReport, TestParameters> generator;

    private TestParameters testParameters;
    private TestReport testReport;
    private URI reportURI;

    @Before
    public void setUp() throws Exception {
        testParameters = new TestParameters();
        testReport = new TestReport();
        reportURI = createTestReportURI();
    }

    @Test
    public void given_parameters__when_generate__then_call_dependences() {
        when(uriBuilder.build(testParameters)).thenReturn(reportURI);
        when(reportReportClassSupplier.reportClass()).thenReturn(TestReport.class);
        when(restTemplate.getForObject(reportURI, TestReport.class)).thenReturn(testReport);

        TestReport result = generator.generate(testParameters);

        assertThat(result.equals(testReport), is(true));
    }

    private URI createTestReportURI() {
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("test.ucar.edu")
                .path("/vi/report")
                .buildAndExpand()
                .toUri();
    }

    private class TestReport {

    }

    private class TestParameters {

    }
}