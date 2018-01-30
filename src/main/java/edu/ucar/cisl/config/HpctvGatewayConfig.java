package edu.ucar.cisl.config;

import edu.ucar.cisl.report.CommonUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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
        return restTemplateBuilder.basicAuthorization(env.getProperty(HpctvProps.SAM_USERNAME), env.getProperty(HpctvProps.SAM_PASSWORD)).build();
    }

    @Bean
    public CommonUriComponentsBuilder commonUriComponentsBuilder() {
        CommonUriComponentsBuilder builder = new CommonUriComponentsBuilder();

        builder.setScheme(env.getProperty(HpctvProps.SAM_SCHEME));
        builder.setHost(env.getProperty(HpctvProps.SAM_HOST));

        if (isSpecified(HpctvProps.SAM_PORT))
            builder.setPort(env.getProperty(HpctvProps.SAM_PORT));

        return builder;
    }

    private Boolean isSpecified(String property) {
        if (env.getProperty(property) != null && !env.getProperty(property).isEmpty()) {
            return true;
        }
        return false;
    }
}
