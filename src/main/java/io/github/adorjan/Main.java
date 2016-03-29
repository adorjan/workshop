/**
 * 
 */
package io.github.adorjan;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adorjan Nagy
 *
 */
public class Main {
    private final static Logger LOG = LoggerFactory.getLogger(Main.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream propertiesInputStream = Main.class.getClassLoader().getResourceAsStream("message.properties")) {
            properties.load(propertiesInputStream);
        } catch (IOException e) {
            LOG.error("Could not load message.properties, I told you.", e);
        }

        LOG.info(properties.getProperty("greeting.message"));
    }

}
