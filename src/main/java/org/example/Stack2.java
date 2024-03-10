package org.example;

import java.util.EmptyStackException;

public class Stack2<T> {

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> top;
    private int size;

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = top;
        top = node;
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T returnValue = top.value;
        top = top.next;
        size--;
        return returnValue;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
