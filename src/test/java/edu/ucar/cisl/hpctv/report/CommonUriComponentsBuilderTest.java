package edu.ucar.cisl.hpctv.report;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommonUriComponentsBuilderTest {

    private CommonUriComponentsBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = new CommonUriComponentsBuilder();
        builder.setHost("host.ucar.edu");
    }

    @Test
    public void given_https_and_port__when_build__then_uri_correct() {
        builder.setScheme("https");
        builder.setPort("8080");
        assertThatBuilderUriMatches("https://host.ucar.edu:8080");
    }

    @Test
    public void given_http_and_port__when_build__then_uri_correct() {
        builder.setScheme("http");
        builder.setPort("8080");
        assertThatBuilderUriMatches("http://host.ucar.edu:8080");
    }

    @Test
    public void given_https_and_no_port__when_build__then_uri_correct() {
        builder.setScheme("https");
        assertThatBuilderUriMatches("https://host.ucar.edu");
    }

    @Test
    public void given_http_and_no_port__when_build__then_uri_correct() {
        builder.setScheme("http");
        assertThatBuilderUriMatches("http://host.ucar.edu");
    }

    private void assertThatBuilderUriMatches(String uri) {
        assertThat(builder.build().buildAndExpand().toUri().toString(), is(uri));
    }
}