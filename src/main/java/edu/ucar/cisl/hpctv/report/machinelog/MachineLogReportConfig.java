package edu.ucar.cisl.hpctv.report.machinelog;

import edu.ucar.cisl.hpctv.config.Factory;
import edu.ucar.cisl.hpctv.config.HpctvConstants;
import edu.ucar.cisl.hpctv.controller.MachineLogReportQuery;
import edu.ucar.cisl.hpctv.query.DefaultMachineLogReportQuery;
import edu.ucar.cisl.hpctv.report.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MachineLogReportConfig {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommonUriComponentsBuilder commonUriComponentsBuilder;

    @Bean
    public UriBuilder<MachineLogReportParameters> machineLogReportUriBuilder() {
        MachineLogReportUriBuilder builder = new MachineLogReportUriBuilder(commonUriComponentsBuilder);
        builder.setPath(HpctvConstants.SAM_ENDPOINT_MACHINELOG_PATH);
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
