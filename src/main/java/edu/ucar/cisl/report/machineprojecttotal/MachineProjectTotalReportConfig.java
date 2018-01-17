package edu.ucar.cisl.report.machineprojecttotal;

import edu.ucar.cisl.config.Factory;
import edu.ucar.cisl.config.HpctvProps;
import edu.ucar.cisl.controller.MachineProjectTotalReportQuery;
import edu.ucar.cisl.query.DefaultMachineProjectTotalReportQuery;
import edu.ucar.cisl.report.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MachineProjectTotalReportConfig {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommonUriComponentsBuilder commonUriComponentsBuilder;

    @Bean
    public UriBuilder<MachineProjectTotalReportParameters> machineProjectTotalReportUriBuilder() {
        MachineProjectTotalReportUriBuilder builder = new MachineProjectTotalReportUriBuilder(commonUriComponentsBuilder);
        builder.setPath(env.getProperty(HpctvProps.SAM_ENDPOINT_MACHINEPROJECTTOTAL_PATH));
        return builder;
    }

    @Bean
    public ReportGenerator<MachineProjectTotalReport, MachineProjectTotalReportParameters> machineProjectTotalReportGenerator() {
        return new RestTemplateReportGenerator<>(restTemplate, machineProjectTotalReportUriBuilder(), () -> MachineProjectTotalReport.class);
    }

    @Bean
    public ReportValidator<MachineProjectTotalReport, MachineProjectTotalReportParameters> machineProjectTotalReportValidator() {
        return new MachineProjectTotalReportValidator();
    }

    @Bean
    public ReportExecutor<MachineProjectTotalReport, MachineProjectTotalReportParameters> machineProjectTotalReportExecutor() {
        return new ReportExecutor<>(machineProjectTotalReportGenerator(), machineProjectTotalReportValidator());
    }

    @Bean
    @Scope("prototype")
    public DefaultMachineProjectTotalReportQuery machineProjectTotalReportQuery() {
        return new DefaultMachineProjectTotalReportQuery(machineProjectTotalReportExecutor());
    }

    @Bean(name = "machineProjectTotalReportQueryFactory")
    public Factory<MachineProjectTotalReportQuery> machineProjectTotalReportQueryFactory() {
        return () -> machineProjectTotalReportQuery();
    }
}
