package edu.ucar.cisl.report.machinelog;

import edu.ucar.cisl.config.Factory;
import edu.ucar.cisl.config.HpctvProps;
import edu.ucar.cisl.controller.MachineLogReportQuery;
import edu.ucar.cisl.query.DefaultMachineLogReportQuery;
import edu.ucar.cisl.report.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MachineLogReportConfig {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommonUriComponentsBuilder commonUriComponentsBuilder;

    @Bean
    public UriBuilder<MachineLogReportParameters> machineLogReportUriBuilder() {
        MachineLogReportUriBuilder builder = new MachineLogReportUriBuilder(commonUriComponentsBuilder);
        builder.setPath(env.getProperty(HpctvProps.SAM_ENDPOINT_MACHINELOG_PATH));
        return builder;
    }

    @Bean
    public ReportGenerator<MachineLogReport, MachineLogReportParameters> machineLogReportGenerator() {
        return new RestTemplateReportGenerator<>(restTemplate, machineLogReportUriBuilder(), () -> MachineLogReport.class);
    }

    @Bean
    public ReportValidator<MachineLogReport, MachineLogReportParameters> machineLogReportValidator() {
        return new MachineLogReportValidator();
    }

    @Bean
    public ReportExecutor<MachineLogReport, MachineLogReportParameters> machineLogReportExecutor() {
        return new ReportExecutor<>(machineLogReportGenerator(), machineLogReportValidator());
    }

    @Bean
    @Scope("prototype")
    public DefaultMachineLogReportQuery machineLogReportQuery() {
        return new DefaultMachineLogReportQuery(machineLogReportExecutor());
    }

    @Bean(name = "machineLogReportQueryFactory")
    public Factory<MachineLogReportQuery> machineLogReportQueryFactory() {
        return () -> machineLogReportQuery();
    }

}
