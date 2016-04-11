package io.github.adorjan.loader;

import java.io.InputStream;
import java.util.Optional;

import io.github.adorjan.Loader;

public class InputStreamLoader implements Loader<InputStream, String> {
    @Override
    public Optional<InputStream> load(String filename) {
        return Optional.ofNullable(InputStreamLoader.class.getClassLoader().getResourceAsStream(filename));
    }
}
