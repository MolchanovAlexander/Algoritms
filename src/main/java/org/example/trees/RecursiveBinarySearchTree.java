package org.example.trees;

import java.util.function.Consumer;
import java.util.stream.Stream;


public class RecursiveBinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {
    private static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> root;
    private int size;

    public static <T extends Comparable<T>> RecursiveBinarySearchTree<T> of(T... elements) {
        RecursiveBinarySearchTree bst = new RecursiveBinarySearchTree<>();
        Stream.of(elements).forEach(bst::insert);
        return bst;
    }

    @Override
    public boolean insert(T element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
            return true;
        } else {
            return insertRecursive(root, element);
        }
    }

    @Override
    public boolean contains(T element) {
        if (element == null) {
            throw new NullPointerException("sfsdf");
        }
        return containsRecursive(root, element);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int depth() {
        return root != null ? depthRecursive(root) - 1 : 0;
    }

    @Override
    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversalRecursive(root, consumer);
    }
    private void inOrderTraversalRecursive(Node<T> current ,Consumer<T> consumer){
        if (current != null) {
            inOrderTraversalRecursive(current.left, consumer);
            consumer.accept(current.element);
            inOrderTraversalRecursive(current.right, consumer);
        }
    }

    private boolean insertRecursive(Node<T> current, T element) {
        if (element.compareTo(current.element) < 0) { // go left
            if (current.left == null) {
                current.left = new Node<>(element);
                size++;
                return true;
            } else {
                return insertRecursive(current.left, element); //recursive go left
            }
        } else if (element.compareTo(current.element) > 0) { // go right
            if (current.right == null) {
                current.right = new Node<>(element);
                size++;
                return true;
            } else {
                return insertRecursive(current.right, element); //recursive go right
            }
        } else {
            return false;
        }
    }

    private boolean containsRecursive(Node<T> current, T element) {
        if (current == null) {
            return false;
        } else if (element.compareTo(current.element) < 0) { // go left
            return containsRecursive(current.left, element);
        } else if (element.compareTo(current.element) > 0) { // go right
            return containsRecursive(current.right, element);
        } else {
            return true;
        }

    }

    private int depthRecursive(Node<T> current) {
        if (current == null) {
            return 0;
        } else {
            return 1 + Math.max(depthRecursive(current.left), depthRecursive(current.right));
        }
    }
}
