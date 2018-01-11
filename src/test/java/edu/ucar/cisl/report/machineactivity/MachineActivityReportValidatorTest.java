package edu.ucar.cisl.report.machineactivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class MachineActivityReportValidatorTest {

    @Mock
    private MachineActivityReport report;

    @Mock
    private MachineActivityReportParameters parameters;

    @InjectMocks
    private MachineActivityReportValidator validator;

    private List<MachineActivityReportEntry> entries;

    @Before
    public void setUp() throws Exception {
        entries = new ArrayList<>();
        when(report.getEntries()).thenReturn(new ArrayList<>());
    }

    @Test
    public void given_no_entries_in_report__when_validate__then_false() {
        assertThat(validator.isValid(report, parameters), is(false));
    }

    @Test
    public void given_entries_in_report__when_validate__then_true() {
        entries.add(mock(MachineActivityReportEntry.class));
        assertThat(validator.isValid(report, parameters), is(false));
    }
}