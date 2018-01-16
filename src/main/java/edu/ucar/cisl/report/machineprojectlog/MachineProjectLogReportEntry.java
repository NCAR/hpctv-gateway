package edu.ucar.cisl.report.machineprojectlog;

import java.math.BigInteger;

public class MachineProjectLogReportEntry {

    private String projcode;
    private String title;
    private String organization;
    private String areaOfInterestGroup;
    private String lead;
    private Integer jobs;
    private BigInteger coreHours;

    public String getProjcode() {
        return projcode;
    }

    public void setProjcode(String projcode) {
        this.projcode = projcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getAreaOfInterestGroup() {
        return areaOfInterestGroup;
    }

    public void setAreaOfInterestGroup(String areaOfInterestGroup) {
        this.areaOfInterestGroup = areaOfInterestGroup;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
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
}
