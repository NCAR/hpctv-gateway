package edu.ucar.cisl.report;

import java.net.URI;

public interface UriBuilder<P> {

    URI build(P parameters);
}
