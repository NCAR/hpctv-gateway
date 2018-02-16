package edu.ucar.cisl.hpctv.report.machineprojectlog;

import edu.ucar.cisl.hpctv.config.Factory;
import edu.ucar.cisl.hpctv.config.HpctvProps;
import edu.ucar.cisl.hpctv.controller.MachineProjectLogReportQuery;
import edu.ucar.cisl.hpctv.report.*;
import edu.ucar.cisl.hpctv.query.DefaultMachineProjectLogReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MachineProjectLogReportConfig {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommonUriComponentsBuilder commonUriComponentsBuilder;

    @Bean
    public UriBuilder<MachineProjectLogReportParameters> machineProjectLogReportUriBuilder() {
        MachineProjectLogReportUriBuilder builder = new MachineProjectLogReportUriBuilder(commonUriComponentsBuilder);
        builder.setPath(env.getProperty(HpctvProps.SAM_ENDPOINT_MACHINEPROJECTLOG_PATH));
        return builder;
    }

    @Bean
    public ReportGenerator<MachineProjectLogReport, MachineProjectLogReportParameters> machineProjectLogReportGenerator() {
        return new RestTemplateReportGenerator<>(restTemplate, machineProjectLogReportUriBuilder(), () -> MachineProjectLogReport.class);
    }

    @Bean
    public ReportValidator<MachineProjectLogReport, MachineProjectLogReportParameters> machineProjectLogReportValidator() {
        return new MachineProjectLogReportValidator();
    }

    @Bean
    public ReportExecutor<MachineProjectLogReport, MachineProjectLogReportParameters> machineProjectLogReportExecutor() {
        return new ReportExecutor<>(machineProjectLogReportGenerator(), machineProjectLogReportValidator());
    }

    @Bean
    @Scope("prototype")
    public DefaultMachineProjectLogReportQuery machineProjectLogReportQuery() {
        return new DefaultMachineProjectLogReportQuery(machineProjectLogReportExecutor());
    }

    @Bean(name = "machineProjectLogReportQueryFactory")
    public Factory<MachineProjectLogReportQuery> machineProjectLogReportQueryFactory() {
        return () -> machineProjectLogReportQuery();
    }

}
