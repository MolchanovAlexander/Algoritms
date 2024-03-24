package org.example.trees;

import java.util.Objects;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public void insert(T data) {
        if (isEmpty()) {
            root = new Node<>(data);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() == null) {
                Node<T> newNode = new Node<>(data);
                node.setLeftChild(newNode);
            } else {
                insert(data, node.getLeftChild());
            }
        } else if (data.compareTo(node.getData()) > 0) {
            if (node.getRightChild() == null) {
                Node<T> newNode = new Node<>(data);
                node.setRightChild(newNode);
            } else {
                insert(data, node.getRightChild());
            }
        }
    }

    public boolean contains(T element) {
        if (element == null) {
            throw new NullPointerException("sfsdf");
        }
        return containsRecursive(root, element);
    }

    private boolean containsRecursive(Node<T> current, T element) {
        if (current == null) {
            return false;
        } else if (element.compareTo(current.data) < 0) { // go left
            return containsRecursive(current.leftChild, element);
        } else if (element.compareTo(current.data) > 0) { // go right
            return containsRecursive(current.rightChild, element);
        } else {
            return true;
        }

    }

    public void delete(T data) {
        root = delete(data, root);
    }

    private Node<T> delete(T data, Node<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(data, node.getRightChild()));
        } else {
            //one child of leaf Node ( no children)
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            //two children
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }
        return node;
    }

    public void traverse() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.println(node);
            traverseInOrder(node.getRightChild());
        }
    }

    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        Node<T> node = root;
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node.getData();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public static class Node<T extends Comparable<T>> {
        T data;
        int height = 1;
        Node<T> leftChild;
        Node<T> rightChild;

        public Node(T data) {
            this.data = data;
        }

        public int getHeight() {
            return height;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public T getData() {
            return data;
        }

        public void setLeftChild(Node<T> newNode) {
            this.leftChild = newNode;
        }

        public void setRightChild(Node<T> newNode) {
            this.rightChild = newNode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return height == node.height
                    && Objects.equals(data, node.data)
                    && Objects.equals(leftChild, node.leftChild)
                    && Objects.equals(rightChild, node.rightChild);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, height, leftChild, rightChild);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", height=" + height +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }

        public void setData(T data) {
            this.data = data;
        }
    }

}
