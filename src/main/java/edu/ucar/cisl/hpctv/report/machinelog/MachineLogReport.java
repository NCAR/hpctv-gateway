package edu.ucar.cisl.hpctv.report.machinelog;

import java.math.BigInteger;

public class MachineLogReport {

    private Integer projects;
    private Integer jobs;
    private BigInteger coreHours;

    public Integer getProjects() {
        return projects;
    }

    public void setProjects(Integer projects) {
        this.projects = projects;
    }

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

    @Override
    public String toString() {
        return "MachineLogReport{" +
                "projects=" + projects +
                ", jobs=" + jobs +
                ", coreHours=" + coreHours +
                '}';
    }
}
