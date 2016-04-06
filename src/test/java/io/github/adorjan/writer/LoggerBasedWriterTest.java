package io.github.adorjan.writer;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoggerBasedWriterTest {

    private LoggerBasedWriter underTest;
    @Mock
    private Logger mockLogger;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new LoggerBasedWriter();
        underTest.setLogger(mockLogger);
    }

    @Test
    public void testWriteShouldLogParameterWhenInvoked() {
        // GIVEN in setUp
        // WHEN
        underTest.write("Hello");
        // THEN
        Mockito.verify(mockLogger).info("Hello");
    }
}
