package edu.ucar.cisl.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ScheduledTasksRunnerTest {

    @InjectMocks
    private ScheduledTasksRunner runner;

    @Test
    public void given_nothing__when_refresh__then() {
        runner.refresh();
    }
}