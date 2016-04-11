package io.github.adorjan.writer;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.mockito.Mock;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoggerBasedWriterTest {

    private LoggerBasedWriter underTest;
    @Mock
    private Logger mockLogger;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        underTest = new LoggerBasedWriter();
        underTest.setLogger(mockLogger);
    }

    @Test
    public void testWriteShouldLogParameterWhenInvoked() {
        // GIVEN in setUp
        // WHEN
        underTest.write("Hello");
        // THEN
        verify(mockLogger).info("Hello");
    }
}
