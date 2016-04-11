package io.github.adorjan.loader;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.mockito.Mock;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PropertiesLoaderTest {

    private final String KEY = "greeting.message";
    private final String VALUE = "Hello All from properties file!";

    private PropertiesLoader underTest;
    @Mock
    private Properties mockProperties;
    @Mock
    private InputStream mockInputStream;
    @Mock
    private Logger mockLogger;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        underTest = new PropertiesLoader();
        underTest.setLogger(mockLogger);
    }

    @Test
    public void testLoadShouldThrowFileNotFoundExceptionWhenInputStreamIsEmpty() {
        // GIVEN in setUp
        // WHEN
        underTest.load(Optional.empty());
        // THEN
        verify(mockLogger, only()).error(matches("Properties file not found"), any(FileNotFoundException.class));
    }

    @Test
    public void testLoadShouldThrowIOExceptionWhenUnableToLoadPropertiesFile() throws IOException {
        // GIVEN
        when(mockInputStream.read(any())).thenThrow(new IOException());
        // WHEN
        underTest.load(Optional.of(mockInputStream));
        // THEN
        verify(mockLogger, only()).error(matches("Unable to load properties file"), any(IOException.class));
    }

    @Test
    public void testLoadShouldReturnPropertiesWhenInvoked() {
        // GIVEN
        InputStream inputStream = new ByteArrayInputStream(String.format("%s=%s", KEY, VALUE).getBytes());
        // WHEN
        Optional<Properties> properties = underTest.load(Optional.of(inputStream));
        // THEN
        assertTrue(properties.isPresent());
        assertEquals(properties.get().getProperty(KEY), VALUE);
    }
}
