package io.github.adorjan.loader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.InputStream;
import java.util.Optional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputStreamLoaderTest {

    private InputStreamLoader underTest;

    @BeforeMethod
    public void setUp() {
        underTest = new InputStreamLoader();
    }

    @Test
    public void testLoadShouldReturnEmptyOptionalWhenFileNotPresent() {
        // GIVEN in setUp
        // WHEN
        Optional<InputStream> inputStream = underTest.load("invalidfile.name");
        // THEN
        assertEquals(inputStream, Optional.empty());
    }

    @Test
    public void testLoadShouldReturnValueWhenInvoked() {
        // GIVEN in setUp
        // WHEN
        Optional<InputStream> inputStream = underTest.load("inputstreamloader.test.file");
        // THEN
        assertTrue(inputStream.isPresent());
    }
}
