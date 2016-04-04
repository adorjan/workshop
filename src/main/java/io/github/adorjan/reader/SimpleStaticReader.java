package io.github.adorjan.reader;

import io.github.adorjan.Reader;

public class SimpleStaticReader implements Reader {

    private final String message;

    public SimpleStaticReader(String message) {
        this.message = message;
    }

    @Override
    public String read() {
        return message;
    }
}
