package edu.ucar.cisl.controller;

import edu.ucar.cisl.config.Factory;
import edu.ucar.cisl.config.HpctvProps;
import edu.ucar.cisl.report.areaofinterestgrouplog.AreaOfInterestGroupLogReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.concurrent.TimeUnit;

@RestController
@Validated
public class AreaOfInterestGroupLogReportController extends BaseController {

    @Autowired
    @Qualifier(value = "areaOfInterestGroupLogReportQueryFactory")
    private Factory<AreaOfInterestGroupLogReportQuery> queryFactory;

    @Autowired
    private Environment env;

    @GetMapping("/v1/report/aoiglog/aoig/{aoig}")
    public ResponseEntity<AreaOfInterestGroupLogReport> getAreaOfInterestGroupLogReport(@PathVariable String aoig,
            @Min(value = 10, message = "daysAgo must be between 10 and 100") @Max(value = 100, message = "daysAgo must be between 10 and 100") @RequestParam Integer daysAgo) {

        AreaOfInterestGroupLogReport report = queryFactory.create()
                .machine(env.getProperty(HpctvProps.SAM_MACHINE))
                .aoig(aoig)
                .daysAgo(daysAgo)
                .query();

        return createOkJSONResponse(report, CacheControl.maxAge(24, TimeUnit.HOURS));
    }

}

