package io.github.adorjan.reader;

import static org.testng.Assert.assertEquals;

import java.util.Optional;
import java.util.Properties;

import org.testng.annotations.Test;

import io.github.adorjan.exception.KeyNotFoundException;

public class PropertiesReaderTest {

    private PropertiesReader underTest;
    private final String KEY = "key";
    private final String KEY_NOT_FOUND_EXCEPTION_MESSAGE = "The given key was not found.";

    @Test(expectedExceptions = KeyNotFoundException.class, expectedExceptionsMessageRegExp = KEY_NOT_FOUND_EXCEPTION_MESSAGE)
    public void testReadShouldThrowKeyNotFoundExceptionWhenNoPropertiesSet() {
        // GIVEN
        underTest = new PropertiesReader(Optional.empty(), KEY);
        // WHEN
        underTest.read();
        // THEN (expect KeyNotFoundException)
    }

    @Test(expectedExceptions = KeyNotFoundException.class, expectedExceptionsMessageRegExp = KEY_NOT_FOUND_EXCEPTION_MESSAGE)
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
        assertEquals(result, KEY);
    }
}
