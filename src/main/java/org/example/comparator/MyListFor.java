package org.example.comparator;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MyListFor<T> extends ArrayList<T> implements MyIterable<T> {
    @Override
    public void myForEach(Consumer<? super T> action) {
        for (T t : this) {
            action.accept(t);
        }
    }
}
