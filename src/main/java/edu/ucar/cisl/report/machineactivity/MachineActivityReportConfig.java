package edu.ucar.cisl.report.machineactivity;

import edu.ucar.cisl.config.Factory;
import edu.ucar.cisl.controller.MachineActivityReportQuery;
import edu.ucar.cisl.query.DefaultMachineActivityReportQuery;
import edu.ucar.cisl.report.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MachineActivityReportConfig {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public UriBuilder<MachineActivityReportParameters> machineActivityReportUriBuilder() {
        MachineActivityReportUriBuilder builder = new MachineActivityReportUriBuilder();

        builder.setScheme(env.getProperty("sam.endpoint.scheme"));
        builder.setHost(env.getProperty("sam.host"));
        builder.setPort(env.getProperty("sam.port"));
        builder.setPath(env.getProperty("sam.endpoint.machineactivity.path"));

        return builder;
    }

    @Bean
    public ReportGenerator<MachineActivityReport, MachineActivityReportParameters> machineActivityReportGenerator() {
        return new RestTemplateReportGenerator<>(restTemplate, machineActivityReportUriBuilder(), () -> MachineActivityReport.class);
    }

    @Bean
    public ReportValidator<MachineActivityReport, MachineActivityReportParameters> machineActivityReportValidator() {
        return new MachineActivityReportValidator();
    }

    @Bean
    public ReportExecutor<MachineActivityReport, MachineActivityReportParameters> machineActivityReportExecutor() {
        return new ReportExecutor<>(machineActivityReportGenerator(), machineActivityReportValidator());
    }

    @Bean
    @Scope("prototype")
    public DefaultMachineActivityReportQuery machineActivityReportQuery() {
        return new DefaultMachineActivityReportQuery(machineActivityReportExecutor());
    }

    @Bean
    public Factory<MachineActivityReportQuery> machineActivityReportQueryFactory() {
        return () -> machineActivityReportQuery();
    }

}