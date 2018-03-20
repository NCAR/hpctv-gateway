package edu.ucar.cisl.hpctv.controller;

import edu.ucar.cisl.hpctv.config.Factory;
import edu.ucar.cisl.hpctv.config.HpctvProps;
import edu.ucar.cisl.hpctv.report.machineactivity.MachineActivityReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.concurrent.TimeUnit;

@RestController
@Validated
public class MachineActivityReportController extends BaseController {

    @Autowired @Qualifier(value = "machineActivityReportQueryFactory")
    private Factory<MachineActivityReportQuery> queryFactory;

    @Autowired
    private Environment env;

    @CrossOrigin
    @GetMapping("/v1/report/activity")
    public ResponseEntity<MachineActivityReport> getMachineActivityReport(
            @Min(value = 1, message = "daysAgo must be between 1 and 100") @Max(value = 100, message = "daysAgo must be between 1 and 100") @RequestParam Integer daysAgo) {

        MachineActivityReport report = queryFactory.create()
                .machine(env.getProperty(HpctvProps.SAM_MACHINE))
                .daysAgo(daysAgo)
                .query();

        return createOkJSONResponse(report, CacheControl.maxAge(24, TimeUnit.HOURS));
    }
}

