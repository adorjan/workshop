/**
 *
 */
package io.github.adorjan;

import java.util.Properties;

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

    private static Reader createReader() {
        Loader<Properties> loader = new PropertiesLoader();
        return new PropertiesReader(loader.load("message.properties"), "greeting.message");
    }

    private static Writer createWriter() {
        return new LoggerBasedWriter();
    }
}
