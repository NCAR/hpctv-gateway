package edu.ucar.cisl.hpctv.report.areaofinterestgrouplog;

import edu.ucar.cisl.hpctv.config.Factory;
import edu.ucar.cisl.hpctv.config.HpctvConstants;
import edu.ucar.cisl.hpctv.controller.AreaOfInterestGroupLogReportQuery;
import edu.ucar.cisl.hpctv.query.DefaultAreaOfInterestGroupLogReportQuery;
import edu.ucar.cisl.hpctv.report.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AreaOfInterestGroupLogReportConfig {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommonUriComponentsBuilder commonUriComponentsBuilder;

    @Bean
    public UriBuilder<AreaOfInterestGroupLogReportParameters> areaOfInterestGroupLogReportUriBuilder() {
        AreaOfInterestGroupLogReportUriBuilder builder = new AreaOfInterestGroupLogReportUriBuilder(commonUriComponentsBuilder);
        builder.setPath(HpctvConstants.SAM_ENDPOINT_AOIGLOG_PATH);
        return builder;
    }

    @Bean
    public ReportGenerator<AreaOfInterestGroupLogReport, AreaOfInterestGroupLogReportParameters> areaOfInterestGroupLogReportGenerator() {
        return new RestTemplateReportGenerator<>(restTemplate, areaOfInterestGroupLogReportUriBuilder(), () -> AreaOfInterestGroupLogReport.class);
    }

    @Bean
    public ReportValidator<AreaOfInterestGroupLogReport, AreaOfInterestGroupLogReportParameters> areaOfInterestGroupLogReportValidator() {
        return new AreaOfInterestGroupLogReportValidator();
    }

    @Bean
    public ReportExecutor<AreaOfInterestGroupLogReport, AreaOfInterestGroupLogReportParameters> areaOfInterestGroupLogReportExecutor() {
        return new ReportExecutor<>(areaOfInterestGroupLogReportGenerator(), areaOfInterestGroupLogReportValidator());
    }

    @Bean
    @Scope("prototype")
    public DefaultAreaOfInterestGroupLogReportQuery areaOfInterestGroupLogReportQuery() {
        return new DefaultAreaOfInterestGroupLogReportQuery(areaOfInterestGroupLogReportExecutor());
    }

    @Bean(name = "areaOfInterestGroupLogReportQueryFactory")
    public Factory<AreaOfInterestGroupLogReportQuery> areaOfInterestGroupLogReportQueryFactory() {
        return () -> areaOfInterestGroupLogReportQuery();
    }

}
