package io.github.adorjan;

import java.util.Optional;

public interface Loader<T> {

    public Optional<T> load(String input);

}
