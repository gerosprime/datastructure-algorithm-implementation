package com.gerosprime.dsa.datastructure.tree;

public class BinarySearchTree<T extends Comparable<T>> {

    public static class Node<T extends Comparable<T>> {

        public T key;

        public Node<T> left;
        public Node<T> right;

        public Node<T> parent;

        public Node(T key) {
            this.key = key;
        }
    }

    private Node<T> root;

    public BinarySearchTree(Node<T> root) {
        this.root = root;
    }

    private Node<T> min(Node<T> node) {

        Node<T> trail = node;

        while (trail.left != null) {
            trail = trail.left;
        }

        return trail;

    }

    public Node<T> min() {
        return min(root);
    }

    private Node<T> minRecursive(Node<T> node) {

        if (node.left == null) {
            return node;
        }

        return minRecursive(node.left);

    }

    private Node<T> maxRecursive(Node<T> node) {

        if (node.right == null) {
            return node;
        }

        return maxRecursive(node.right);

    }

    public Node<T> max(Node<T> node) {

        Node<T> trail = node;

        while (trail.right != null) {
            trail = trail.right;
        }

        return trail;

    }

    public Node<T> max() {
        return max(root);
    }

    public Node<T> search(T key) {

        Node<T> trail = root;

        while (trail != null) {

            if (trail.key.equals(key)) {
                return trail;
            } else {
                if (trail.key.compareTo(key) > 0) {
                    trail = trail.left;
                } else {
                    trail = trail.right;
                }
            }

        }

        return null;

    }

    public void insert(Node<T> node) {

        Node<T> trail = root;
        Node<T> parent = null;

        while (trail != null) {
            parent = trail;
            if (trail.key.compareTo(node.key) > 0) {

                trail = trail.left;

            } else {
                trail =  trail.right;
            }
        }

        node.parent = parent;

        if (parent == null) {
            parent = node;
        }
        else if (parent.key.compareTo(node.key) > 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }

    }

    public Node<T> successor(Node<T> node) {

        if (node.right != null) {
            return min(node.right);
        }

        Node<T> parent = node.parent;

        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }

        return parent;

    }

    private void printInOrder(Node<T> node) {
        if (node == null) {
            return;
        }

        printInOrder(node.left);
        System.out.println(node.key);
        printInOrder(node.right);

    }

    public void printInOrder() {
        printInOrder(root);
    }


    public static void main(String[] args) {

        Node<Integer> root = new Node<>(13);

        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>(root);
        searchTree.insert(new Node<>(15));
        searchTree.insert(new Node<>(10));
        searchTree.insert(new Node<>(9));
        searchTree.insert(new Node<>(8));
        searchTree.insert(new Node<>(22));
        searchTree.insert(new Node<>(12));
        searchTree.insert(new Node<>(11));
        searchTree.insert(new Node<>(13));
        searchTree.insert(new Node<>(14));

        searchTree.printInOrder();

        System.out.println("Successor: " + searchTree.successor(searchTree.search(15)).key);

    }

}
