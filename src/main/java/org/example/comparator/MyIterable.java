package org.example.comparator;

import java.util.function.Consumer;

public interface MyIterable<T> {
    void myForEach(Consumer<? super T> action);
}
