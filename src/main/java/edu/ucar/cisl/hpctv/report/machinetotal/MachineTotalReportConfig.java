package edu.ucar.cisl.hpctv.report.machinetotal;

import edu.ucar.cisl.hpctv.config.Factory;
import edu.ucar.cisl.hpctv.config.HpctvConstants;
import edu.ucar.cisl.hpctv.controller.MachineTotalReportQuery;
import edu.ucar.cisl.hpctv.query.DefaultMachineTotalReportQuery;
import edu.ucar.cisl.hpctv.report.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MachineTotalReportConfig {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommonUriComponentsBuilder commonUriComponentsBuilder;

    @Bean
    public UriBuilder<MachineTotalReportParameters> machineTotalReportUriBuilder() {
        MachineTotalReportUriBuilder builder = new MachineTotalReportUriBuilder(commonUriComponentsBuilder);
        builder.setPath(HpctvConstants.SAM_ENDPOINT_MACHINETOTAL_PATH);
        return builder;
    }

    @Bean
    public ReportGenerator<MachineTotalReport, MachineTotalReportParameters> machineTotalReportGenerator() {
        return new RestTemplateReportGenerator<>(restTemplate, machineTotalReportUriBuilder(), () -> MachineTotalReport.class);
    }

    @Bean
    public ReportValidator<MachineTotalReport, MachineTotalReportParameters> machineTotalReportValidator() {
        return new MachineTotalReportValidator();
    }

    @Bean
    public ReportExecutor<MachineTotalReport, MachineTotalReportParameters> machineTotalReportExecutor() {
        return new ReportExecutor<>(machineTotalReportGenerator(), machineTotalReportValidator());
    }

    @Bean
    @Scope("prototype")
    public DefaultMachineTotalReportQuery machineTotalReportQuery() {
        return new DefaultMachineTotalReportQuery(machineTotalReportExecutor());
    }

    @Bean(name = "machineTotalReportQueryFactory")
    public Factory<MachineTotalReportQuery> machineTotalReportQueryFactory() {
        return () -> machineTotalReportQuery();
    }

}
