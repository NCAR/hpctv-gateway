package edu.ucar.cisl.controller;

import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class BaseController {

    protected ResponseEntity createOkJSONResponse(Object body, CacheControl cacheControl) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .cacheControl(cacheControl)
                .body(body);
    }
}
