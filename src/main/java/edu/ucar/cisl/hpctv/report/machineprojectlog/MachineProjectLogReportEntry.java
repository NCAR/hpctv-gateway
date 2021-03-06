package edu.ucar.cisl.hpctv.report.machineprojectlog;

import java.math.BigInteger;

public class MachineProjectLogReportEntry {

    private String projcode;
    private String title;
    private String organization;
    private String areaOfInterestGroup;
    private String facility;
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

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
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

    @Override
    public String toString() {
        return "MachineProjectLogReportEntry{" +
                "projcode='" + projcode + '\'' +
                ", title='" + title + '\'' +
                ", organization='" + organization + '\'' +
                ", areaOfInterestGroup='" + areaOfInterestGroup + '\'' +
                ", facility='" + facility + '\'' +
                ", lead='" + lead + '\'' +
                ", jobs=" + jobs +
                ", coreHours=" + coreHours +
                '}';
    }
}
