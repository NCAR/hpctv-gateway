package edu.ucar.cisl.controller;

import edu.ucar.cisl.config.Factory;
import edu.ucar.cisl.report.machineactivity.MachineActivityReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@Validated
public class MachineActivityReportController {

    @Autowired
    private Factory<MachineActivityReportQuery> queryFactory;

    @Autowired @Qualifier(value = "machine")
    private String machine;

    @GetMapping(value = "/v1/report/activity", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MachineActivityReport getMachineActivityReport(
            @Min(value = 10, message = "daysAgo must be between 10 and 100") @Max(value = 100, message = "daysAgo must be between 10 and 100") @RequestParam Integer daysAgo) {
        return queryFactory.create()
                .machine(machine)
                .daysAgo(daysAgo)
                .query();
    }
}

