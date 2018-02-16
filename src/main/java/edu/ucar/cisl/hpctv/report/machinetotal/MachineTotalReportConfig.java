package edu.ucar.cisl.hpctv.report.machinetotal;

import edu.ucar.cisl.hpctv.config.Factory;
import edu.ucar.cisl.hpctv.config.HpctvProps;
import edu.ucar.cisl.hpctv.controller.MachineTotalReportQuery;
import edu.ucar.cisl.hpctv.report.*;
import edu.ucar.cisl.hpctv.query.DefaultMachineTotalReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MachineTotalReportConfig {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommonUriComponentsBuilder commonUriComponentsBuilder;

    @Bean
    public UriBuilder<MachineTotalReportParameters> machineTotalReportUriBuilder() {
        MachineTotalReportUriBuilder builder = new MachineTotalReportUriBuilder(commonUriComponentsBuilder);
        builder.setPath(env.getProperty(HpctvProps.SAM_ENDPOINT_MACHINETOTAL_PATH));
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
