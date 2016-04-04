/**
 *
 */
package io.github.adorjan;

import io.github.adorjan.reader.SimpleStaticReader;
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
        Reader reader = new SimpleStaticReader("Helloka");
        Writer writer = new LoggerBasedWriter();
        App app = new App(reader, writer);
        app.doRun();
    }
}
