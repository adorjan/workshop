package io.github.adorjan;

import java.util.Optional;

public interface Loader<T, V> {

    public Optional<T> load(V input);

}
