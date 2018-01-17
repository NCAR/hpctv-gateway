package edu.ucar.cisl.report.machineprojecttotal;

import java.math.BigInteger;

public class MachineProjectTotalReport {

    private Integer jobs;
    private BigInteger coreHours;

    public Integer getJobs() {
        return jobs;
    }

    public void setJobs(Integer jobs) {
        this.jobs = jobs;
    }

    public BigInteger getCoreHours() {
        return coreHours;
    }

    public void setCoreHours(BigInteger coreHours) {
        this.coreHours = coreHours;
    }
}
