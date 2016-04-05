package io.github.adorjan.loader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.adorjan.Loader;

public class PropertiesLoader implements Loader<Properties> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesLoader.class);

    @Override
    public Optional<Properties> load(String filename) {
        Optional<Properties> properties = Optional.empty();
        try (InputStream propertiesInputStream = getPropertiesInputStream(filename)) {
            properties = Optional.of(loadProperties(propertiesInputStream));
        } catch (FileNotFoundException e) {
            LOGGER.error("Properties file not found {}", filename, e);
        } catch (IOException e) {
            LOGGER.error("Unable to load properties file {}", filename, e);
        }
        return properties;
    }

    private Properties loadProperties(InputStream propertiesInputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(propertiesInputStream);
        return properties;
    }

    private InputStream getPropertiesInputStream(String filename) throws FileNotFoundException {
        InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            throw new FileNotFoundException();
        }
        return inputStream;
    }
}
