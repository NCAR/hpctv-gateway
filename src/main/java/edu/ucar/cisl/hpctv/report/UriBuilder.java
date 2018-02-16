package edu.ucar.cisl.hpctv.report;

import java.net.URI;

public interface UriBuilder<P> {

    URI build(P parameters);
}
