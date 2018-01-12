package edu.ucar.cisl.report;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AbstractUriBuilderTest {

    private CommonUriComponentsBuilder commonUriComponentsBuilder;
    private TestReportParameters parameters;
    private TestUriBuilder builder;

    @Before
    public void setUp() throws Exception {
        commonUriComponentsBuilder = new CommonUriComponentsBuilder();
        commonUriComponentsBuilder.setScheme("http");
        commonUriComponentsBuilder.setHost("host.ucar.edu");

        builder = new TestUriBuilder(commonUriComponentsBuilder);
        builder.setPath("/api/a/{a}");

        parameters = new TestReportParameters();
        parameters.setParameterA("jack");
        parameters.setParameterB("jill");
    }

    @Test
    public void given_uri_and_request_parameters__when_build__then_uri_correct() {
        assertThatBuilderUriMatches("http://host.ucar.edu/api/a/jack?b=jill");
    }

    private void assertThatBuilderUriMatches(String uri) {
        assertThat(builder.build(parameters).toString(), is(uri));
    }

    private class TestReportParameters {

        private String parameterA;
        private String parameterB;

        public String getParameterA() {
            return parameterA;
        }

        public void setParameterA(String parameterA) {
            this.parameterA = parameterA;
        }

        public String getParameterB() {
            return parameterB;
        }

        public void setParameterB(String paramB) {
            this.parameterB = paramB;
        }
    }

    private class TestUriBuilder extends AbstractUriBuilder<TestReportParameters> implements UriBuilder<TestReportParameters> {

        public TestUriBuilder(CommonUriComponentsBuilder commonUriComponentsBuilder) {
            super(commonUriComponentsBuilder);
        }

        @Override
        protected UriComponentsBuilder addQueryParams(UriComponentsBuilder builder, TestReportParameters parameters) {
            return builder.queryParam("b", parameters.getParameterB());
        }

        @Override
        protected void addUriParams(Map<String, String> uriParams, TestReportParameters parameters) {
            uriParams.put("a", parameters.getParameterA());
        }
    }
}