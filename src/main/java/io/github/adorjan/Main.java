/**
 *
 */
package io.github.adorjan;

import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import io.github.adorjan.loader.InputStreamLoader;
import io.github.adorjan.loader.PropertiesLoader;
import io.github.adorjan.reader.PropertiesReader;
import io.github.adorjan.writer.LoggerBasedWriter;

/**
 * @author Adorjan Nagy
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        createApp().doRun();
    }

    private static App createApp() {
        return new App(createReader(), createWriter());
    }

    private static Optional<InputStream> createInputStream() {
        return new InputStreamLoader().load("message.properties");
    }

    private static Optional<Properties> createProperties(Optional<InputStream> inputStream) {
        return new PropertiesLoader().load(inputStream);
    }

    private static Reader createReader() {
        return new PropertiesReader(createProperties(createInputStream()), "greeting.message");
    }

    private static Writer createWriter() {
        return new LoggerBasedWriter();
    }
}
