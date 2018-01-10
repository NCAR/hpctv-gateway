package edu.ucar.cisl.report.machineactivity;

import java.util.ArrayList;
import java.util.List;

public class MachineActivityReport {

    public List<MachineActivityReportEntry> entries = new ArrayList<>();

    public List<MachineActivityReportEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<MachineActivityReportEntry> entries) {
        this.entries = entries;
    }
}
