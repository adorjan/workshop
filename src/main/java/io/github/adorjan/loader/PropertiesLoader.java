package io.github.adorjan.loader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.adorjan.Loader;

public class PropertiesLoader implements Loader<Properties, Optional<InputStream>> {

    private Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    @Override
    public Optional<Properties> load(Optional<InputStream> inputStream) {
        Optional<Properties> properties = Optional.empty();
        try (InputStream propertiesInputStream = inputStream.orElseThrow(() -> new FileNotFoundException())) {
            properties = Optional.of(loadProperties(propertiesInputStream));
        } catch (FileNotFoundException e) {
            logger.error("Properties file not found", e);
        } catch (IOException e) {
            logger.error("Unable to load properties file", e);
        }
        return properties;
    }

    private Properties loadProperties(InputStream propertiesInputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(propertiesInputStream);
        return properties;
    }

    void setLogger(Logger logger) {
        this.logger = logger;
    }
}
