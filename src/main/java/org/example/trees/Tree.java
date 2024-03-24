package org.example.trees;

public interface Tree<T extends Comparable<T>> {

    void insert(T data);

    void delete(T data);

    void traverse();

    T getMax();

    T getMin();

    boolean isEmpty();

}
