package io.github.adorjan.reader;

import java.util.Optional;
import java.util.Properties;

import io.github.adorjan.Reader;

public class PropertiesReader implements Reader {

    private final Optional<Properties> properties;
    private final String key;

    public PropertiesReader(Optional<Properties> properties, String key) {
        this.properties = properties;
        this.key = key;
    }

    @Override
    public String read() {
        String result = "Properties file not found.";
        if (properties.isPresent()) {
            if (properties.get().containsKey(key)) {
                result = properties.get().getProperty(key);
            } else {
                result = String.format("Key (%s) not found.", key);
            }
        }
        return result;
    }
}
