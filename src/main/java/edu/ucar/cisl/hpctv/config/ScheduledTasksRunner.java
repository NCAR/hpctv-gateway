package edu.ucar.cisl.hpctv.config;

import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledTasksRunner {

    @Scheduled(cron = "0 */10 * * * ?")
    public void refresh() {

    }

}
