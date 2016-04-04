package io.github.adorjan;

public class App {

    private final Reader reader;
    private final Writer writer;

    public App(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void doRun() {
        writer.write(reader.read());
    }
}
