package org.example.trees;

public class MyAVLTree {
    //@Data
    public class Node<T extends  Comparable<T>> {
        //@NonNull
        private T data;
        int height = 1;
        private Node<T> leftChild;
        private Node<T> rightChild;
    }
}
