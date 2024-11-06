package org.example.comparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class MyList<T> extends ArrayList<T> implements MyIterable<T> {
    @Override
    public void myForEach(Consumer<? super T> action) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            action.accept(t);
        }
    }
}
