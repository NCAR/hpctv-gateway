package edu.ucar.cisl.controller;

import edu.ucar.cisl.config.Factory;
import edu.ucar.cisl.report.machineactivity.MachineActivityReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MachineActivityReportController {

    @Autowired
    private Factory<MachineActivityReportQuery> queryFactory;

    @Autowired @Qualifier(value ="machine")
    private String machine;

    @GetMapping("/v1/report/activity")
    @ResponseBody
    public MachineActivityReport getMachineActivityReport(@RequestParam Integer daysAgo) {
        return queryFactory.create()
                .machine(machine)
                .daysAgo(daysAgo)
                .query();
    }
}

