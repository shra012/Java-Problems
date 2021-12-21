package com.shra012.cracking.coding.interview.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    /**
     * Public constructor to initialize the binary search tree.
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Inserts the data into the binary tree, based on natural ordering or
     * Comparable objects ordering.
     *
     * @param data - data to be inserted.
     */
    public void insert(T data) {
        if (data == null) {
            return;
        }

        size++;
        if (this.root == null) {
            this.root = new Node<>(data);
            return;
        }

        insert(root, data);
    }

    /**
     * Recursively inserts the data into the binary search tree
     * based on natural order.
     *
     * @param root - root node.
     * @param data - data to insert.
     */
    private void insert(Node<T> root, T data) {
        if (root.getData().compareTo(data) >= 0) {
            if (root.getLeft() == null) {
                root.setLeft(new Node<>(data));
            } else {
                insert(root.getLeft(), data);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new Node<>(data));
            } else {
                insert(root.getRight(), data);
            }
        }
    }

    /**
     * checks if the given data exists in the binary tree.
     *
     * @param data - the data to be checked for existence in the tree.
     * @return true if the tree contains the data.
     */
    public boolean contains(T data) {
        return contains(this.root, data);
    }

    /**
     * checks if the given data exists in the binary tree.
     *
     * @param root the root node.
     * @param data - the data to be checked for existence in the tree.
     * @return true if the tree contains the data.
     */
    private boolean contains(Node<T> root, T data) {
        if (root == null || data == null) {
            return false;
        }
        if (root.getData().equals(data)) {
            return true;
        }
        if (root.getData().compareTo(data) >= 0) {
            return contains(root.getLeft(), data);
        } else {
            return contains(root.getRight(), data);
        }
    }

    /**
     * returns the minimum value in the binary tree.
     *
     * @return - the minimum value in the tree.
     */
    public T minimum() {
        if (this.root == null) {
            return null;
        }
        Node<T> temp = this.root;
        T minimum = temp.getData();
        while (temp.getLeft() != null) {
            minimum = temp.getLeft().getData();
            temp = temp.getLeft();
        }

        return minimum;
    }

    /**
     * returns the maximum value in the binary tree.
     *
     * @return - the maximum value in the tree.
     */
    public T maximum() {
        if (this.root == null) {
            return null;
        }
        Node<T> temp = this.root;
        T maximum = temp.getData();
        while (temp.getRight() != null) {
            maximum = temp.getRight().getData();
            temp = temp.getRight();
        }

        return maximum;
    }

    /**
     * finds the values in the binary tree within the specified range.
     * it is inclusive of both the lower bound and upper bound.
     *
     * @param min - the lower bound.
     * @param max - the max bound.
     * @return a list with the values in the binary tree within the specified range.
     */
    public List<T> between(T min, T max) {
        return Collections.unmodifiableList(between(this.root, new ArrayList<>(), min, max));
    }

    /**
     * recursively collects the values in the binary tree within the specified range.
     *
     * @param root - root node.
     * @param list - list in which the collected result is stored.
     * @param min  - minimum range.
     * @param max  - maximum range.
     * @return - returns a list of elements between minimum and maximum range.
     */
    private List<T> between(Node<T> root, List<T> list, T min, T max) {
        if (root == null) {
            return list;
        }

        if (root.getData().compareTo(min) >= 0) {
            between(root.getLeft(), list, min, max);
        }

        if (root.getData().compareTo(min) >= 0 && root.getData().compareTo(max) <= 0) {
            list.add(root.getData());
        }

        if (root.getData().compareTo(max) <= 0) {
            between(root.getRight(), list, min, max);
        }

        return list;
    }

    /**
     * Depth First Search with In Order Traversal.
     *
     * @return a list with the data in the tree in order.
     */
    public List<T> inOrder() {
        return Collections.unmodifiableList(inOrder(this.root, new ArrayList<>()));
    }

    /**
     * Depth First Search with In Order Traversal.
     *
     * @param root - root node.
     * @param list - list with the values inserted with in order traversal.
     * @return a list with the data in the tree in order.
     */
    private List<T> inOrder(Node<T> root, List<T> list) {
        if (root == null) {
            return list;
        }
        inOrder(root.getLeft(), list);
        list.add(root.getData());
        inOrder(root.getRight(), list);
        return list;
    }

    /**
     * checks if the current tree is a valid binary tree.
     * <p>
     * Valid binary trees have the current nodes value
     * greater than the left and lesser than the right.
     *
     * @return true if the tree is a valid binary tree.
     */
    public boolean isValid() {
        return isValid(this.root);
    }

    /**
     * checks if the current tree is a valid binary tree.
     * <p>
     * Valid binary trees have the current nodes value
     * greater than the left and lesser than the right.
     *
     * @param root - root node.
     * @return true if the tree is a valid binary tree.
     */
    private boolean isValid(Node<T> root) {
        if (root == null) {
            return true;
        }
        if (root.getLeft() != null && root.getData().compareTo(root.getLeft().getData()) < 0) {
            return false;
        }
        if (root.getRight() != null && root.getData().compareTo(root.getRight().getData()) >= 0) {
            return false;
        }

        return isValid(root.getLeft()) && isValid(root.getRight());
    }

    /**
     * To string prints the binary search tree.
     */
    @Override
    public String toString() {
        return "Binary Search Tree\n" + root.printTree();
    }

    /**
     * Size of the binary tree.
     *
     * @return - the number of nodes in a tree.
     */
    public int size() {
        return size;
    }

    /**
     * Default root method to access the node for tests
     * or internal use with the package.
     *
     * @return the root node element.
     */
    Node<T> getRoot() {
        return this.root;
    }
}
