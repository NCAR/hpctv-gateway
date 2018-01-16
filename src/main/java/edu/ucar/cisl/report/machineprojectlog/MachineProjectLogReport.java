package edu.ucar.cisl.report.machineprojectlog;

import java.util.ArrayList;
import java.util.List;

public class MachineProjectLogReport {

    private List<MachineProjectLogReportEntry> entries = new ArrayList<>();

    public List<MachineProjectLogReportEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<MachineProjectLogReportEntry> entries) {
        this.entries = entries;
    }
}
