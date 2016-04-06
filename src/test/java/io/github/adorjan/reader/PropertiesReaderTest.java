package io.github.adorjan.reader;

import java.util.Optional;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.adorjan.exception.KeyNotFoundException;

public class PropertiesReaderTest {

    private PropertiesReader underTest;
    private final String KEY = "key";

    @Test(expectedExceptions = KeyNotFoundException.class)
    public void testReadShouldThrowKeyNotFoundExceptionWhenNoPropertiesSet() {
        // GIVEN
        underTest = new PropertiesReader(Optional.empty(), KEY);
        // WHEN
        underTest.read();
        // THEN (expect KeyNotFoundException)
    }

    @Test(expectedExceptions = KeyNotFoundException.class)
    public void testReadShouldThrowKeyNotFoundExceptionWhenPropertiesSetAndKeyIsNotPresent() {
        // GIVEN
        Properties properties = new Properties();
        underTest = new PropertiesReader(Optional.of(properties), KEY);
        // WHEN
        underTest.read();
        // THEN (expect KeyNotFoundException)
    }

    @Test
    public void testReadShouldReturnValueWhenPropertiesSetAndKeyIsPresent() {
        // GIVEN
        Properties properties = new Properties();
        properties.put(KEY, KEY);
        underTest = new PropertiesReader(Optional.of(properties), KEY);
        // WHEN
        String result = underTest.read();
        // THEN
        Assert.assertEquals(result, KEY);
    }
}
