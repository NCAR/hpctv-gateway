package edu.ucar.cisl.controller;

import edu.ucar.cisl.config.Factory;
import edu.ucar.cisl.config.HpctvProps;
import edu.ucar.cisl.report.machineactivity.MachineActivityReport;
import edu.ucar.cisl.report.machinetotal.MachineTotalReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Validated
public class MachineTotalReportController extends BaseController {

    @Autowired @Qualifier(value = "machineTotalReportQueryFactory")
    private Factory<MachineTotalReportQuery> queryFactory;

    @Autowired
    private Environment env;

    @GetMapping("/v1/report/total")
    public ResponseEntity<MachineActivityReport> getMachineTotalReport() {

        MachineTotalReport report = queryFactory.create()
                .machine(env.getProperty(HpctvProps.SAM_MACHINE))
                .query();

        return createOkJSONResponse(report, CacheControl.maxAge(24, TimeUnit.HOURS));
    }
}
