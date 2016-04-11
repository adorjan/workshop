package io.github.adorjan.reader;

import java.util.Optional;
import java.util.Properties;

import io.github.adorjan.Reader;
import io.github.adorjan.exception.KeyNotFoundException;

public class PropertiesReader implements Reader {

    private final Properties properties;
    private final String key;

    public PropertiesReader(Optional<Properties> properties, String key) {
        this.properties = properties.orElse(new Properties());
        this.key = key;
    }

    @Override
    public String read() {
        String result;
        if (properties.containsKey(key)) {
            result = properties.getProperty(key);
        } else {
            throw new KeyNotFoundException();
        }
        return result;
    }
}
