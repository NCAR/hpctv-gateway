package edu.ucar.cisl.report.machineactivity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MachineActivityReportEntry {
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Integer users;
    private Integer jobs;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    public Integer getJobs() {
        return jobs;
    }

    public void setJobs(Integer jobs) {
        this.jobs = jobs;
    }

    @Override public String toString() {
        return "MachineActivityReportEntry{" +
                "date=" + date +
                ", users=" + users +
                ", jobs=" + jobs +
                '}';
    }
}
