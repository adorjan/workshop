package io.github.adorjan.loader;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.testng.Assert;
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
        MockitoAnnotations.initMocks(this);
        underTest = new PropertiesLoader();
        underTest.setLogger(mockLogger);
    }

    @Test
    public void testLoadShouldThrowFileNotFoundExceptionWhenInputStreamIsEmpty() {
        // GIVEN in setUp
        // WHEN
        underTest.load(Optional.empty());
        // THEN
        Mockito.verify(mockLogger, Mockito.only()).error(Mockito.anyString(), Mockito.any(FileNotFoundException.class));
    }

    @Test
    public void testLoadShouldThrowIOExceptionWhenUnableToLoadPropertiesFile() throws IOException {
        // GIVEN in setUp
        // WHEN
        Mockito.when(mockInputStream.read(Mockito.any())).thenThrow(new IOException());
        underTest.load(Optional.of(mockInputStream));
        // THEN
        Mockito.verify(mockLogger, Mockito.only()).error(Mockito.anyString(), Mockito.any(IOException.class));
    }

    @Test
    public void testLoadShouldReturnPropertiesWhenInvoked() {
        // GIVEN
        InputStream inputStream = new ByteArrayInputStream(String.format("%s=%s", KEY, VALUE).getBytes());
        // WHEN
        Optional<Properties> properties = underTest.load(Optional.of(inputStream));
        // THEN
        Assert.assertTrue(properties.isPresent());
        Assert.assertEquals(properties.get().getProperty(KEY), VALUE);
    }
}
