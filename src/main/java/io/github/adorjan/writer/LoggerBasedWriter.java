package io.github.adorjan.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.adorjan.Writer;

public class LoggerBasedWriter implements Writer {

    private Logger logger = LoggerFactory.getLogger(LoggerBasedWriter.class);

    @Override
    public void write(String message) {
        logger.info(message);
    }

    void setLogger(Logger logger) {
        this.logger = logger;
    }
}
