package edu.ucar.cisl.config;

import edu.ucar.cisl.controller.MachineActivityReportQuery;
import edu.ucar.cisl.query.DefaultMachineActivityReportQuery;
import edu.ucar.cisl.report.ReportExecutor;
import edu.ucar.cisl.report.ReportGenerator;
import edu.ucar.cisl.report.ReportValidator;
import edu.ucar.cisl.report.UriBuilder;
import edu.ucar.cisl.report.machineactivity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("file:${hpctv-gateway.properties}")
public class HpctvGatewayConfig {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ScheduledTasksRunner scheduledTasksRunner() {
        return new ScheduledTasksRunner();
    }

    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder.basicAuthorization(env.getProperty("sam.username"), env.getProperty("sam.password")).build();
    }

    @Bean
    public String machine() {
        return env.getProperty("sam.machine");
    }

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
        return new MachineActivityReportGenerator(restTemplate(), machineActivityReportUriBuilder());
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
