package edu.ucar.cisl.hpctv.controller;

import edu.ucar.cisl.hpctv.config.Factory;
import edu.ucar.cisl.hpctv.config.HpctvProps;
import edu.ucar.cisl.hpctv.report.machineprojecttotal.MachineProjectTotalReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Validated
public class MachineProjectTotalReportController extends BaseController {

    @Autowired @Qualifier(value = "machineProjectTotalReportQueryFactory")
    private Factory<MachineProjectTotalReportQuery> queryFactory;

    @Autowired
    private Environment env;

    @CrossOrigin
    @GetMapping("/v1/report/projecttotal/project/{projcode}")
    public ResponseEntity<MachineProjectTotalReport> getMachineProjectTotalReport(@PathVariable String projcode) {

        MachineProjectTotalReport report = queryFactory.create()
                .machine(env.getProperty(HpctvProps.SAM_MACHINE))
                .projcode(projcode)
                .query();

        return createOkJSONResponse(report, CacheControl.maxAge(24, TimeUnit.HOURS));
    }
}
