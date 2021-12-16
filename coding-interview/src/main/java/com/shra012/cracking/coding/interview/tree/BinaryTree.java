package com.shra012.cracking.coding.interview.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree(Node<T> node) {
        this.root = node;
    }

    @Override
    public String toString() {

        return "Binary Tree\n" + root.toString();

    }

    public LinkedList<T> breadthFirst() {
        LinkedList<T> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            list.add(node.getData());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return list;
    }

    public LinkedList<T> inOrderTraversal() {
        LinkedList<T> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Set<Node<T>> visited = new HashSet<>();
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            if (current.getLeft() == null && current.getRight() == null) {
                list.add(current.getData());
            } else if (visited.contains(current)) {
                list.add(current.getData());
            } else {
                visited.add(current);
                if (current.getRight() != null) {
                    stack.push(current.getRight());
                }
                stack.push(current);
                if (current.getLeft() != null) {
                    stack.push(current.getLeft());
                }
            }
        }
        return list;
    }

    public LinkedList<T> inOrderTraversalWithRecursion() {
        LinkedList<T> list = new LinkedList<>();
        inOrderTraversalWithRecursion(root, list);
        return list;
    }

    private void inOrderTraversalWithRecursion(Node<T> root, LinkedList<T> list) {
        if (root == null) {
            return;
        }
        inOrderTraversalWithRecursion(root.getLeft(), list);
        list.add(root.getData());
        inOrderTraversalWithRecursion(root.getRight(), list);
    }

    public LinkedList<T> preOrderTraversal() {
        LinkedList<T> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Set<Node<T>> visited = new HashSet<>();
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            if (current.getLeft() == null && current.getRight() == null) {
                list.add(current.getData());
            } else if (visited.contains(current)) {
                list.add(current.getData());
            } else {
                visited.add(current);
                if (current.getRight() != null) {
                    stack.push(current.getRight());
                }
                if (current.getLeft() != null) {
                    stack.push(current.getLeft());
                }
                stack.push(current);
            }
        }
        return list;
    }

    public LinkedList<T> preOrderTraversalWithRecursion() {
        LinkedList<T> list = new LinkedList<>();
        preOrderTraversalWithRecursion(root, list);
        return list;
    }

    private void preOrderTraversalWithRecursion(Node<T> root, LinkedList<T> list) {
        if (root == null) {
            return;
        }
        list.add(root.getData());
        preOrderTraversalWithRecursion(root.getLeft(), list);
        preOrderTraversalWithRecursion(root.getRight(), list);
    }

    public LinkedList<T> postOrderTraversal() {
        LinkedList<T> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Set<Node<T>> visited = new HashSet<>();
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            if (current.getLeft() == null && current.getRight() == null) {
                list.add(current.getData());
            } else if (visited.contains(current)) {
                list.add(current.getData());
            } else {
                visited.add(current);
                stack.push(current);
                if (current.getRight() != null) {
                    stack.push(current.getRight());
                }
                if (current.getLeft() != null) {
                    stack.push(current.getLeft());
                }
            }
        }
        return list;
    }

    public LinkedList<T> postOrderTraversalWithRecursion() {
        LinkedList<T> list = new LinkedList<>();
        postOrderTraversalWithRecursion(root, list);
        return list;
    }

    private void postOrderTraversalWithRecursion(Node<T> root, LinkedList<T> list) {
        if (root == null) {
            return;
        }
        postOrderTraversalWithRecursion(root.getLeft(), list);
        postOrderTraversalWithRecursion(root.getRight(), list);
        list.add(root.getData());
    }

    public int nodes() {
        return nodes(root);
    }

    private int nodes(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return nodes(root.getLeft()) + nodes(root.getRight()) + 1;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    public int maxDepth(Node<T> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean hasPathSum(int sum) {
        if (Number.class.isAssignableFrom(root.getData().getClass())) {
            return hasPathSumRecursion(root, sum, 0);
        } else {
            throw new IllegalStateException("Called has path sum when the data is not instance of Number class");
        }
    }

    private boolean hasPathSumRecursion(Node<T> root, Integer expectedSum, Integer actualSum) {
        if (root == null) {
            return false;
        }
        actualSum += ((Number) root.getData()).intValue();
        if (root.getLeft() == null && root.getRight() == null && expectedSum != 0) {
            return actualSum == expectedSum;
        }
        return hasPathSumRecursion(root.getLeft(), expectedSum, actualSum)
                || hasPathSumRecursion(root.getRight(), expectedSum, actualSum);
    }

    public boolean hasPathSumSubtraction(int sum) {
        if (Number.class.isAssignableFrom(root.getData().getClass())) {
            return hasPathSumSubtraction(root, sum);
        } else {
            throw new IllegalStateException("Called has path sum when the data is not instance of Number class");
        }
    }

    private boolean hasPathSumSubtraction(Node<T> root, Integer sum) {
        if (root == null) {
            return false;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return sum == root.getData();
        }
        return hasPathSumSubtraction(root.getLeft(), sum - ((Number) root.getData()).intValue())
                || hasPathSumSubtraction(root.getRight(), sum - ((Number) root.getData()).intValue());
    }

    public void mirror() {
        mirror(root);
    }

    private void mirror(Node<T> root) {
        if (root == null) {
            return;
        }
        Node<T> temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        mirror(root.getLeft());
        mirror(root.getRight());
    }

    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(Node<T> root) {
        if (root == null) {
            return true;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return true;
        } else if (root.getLeft() != null && root.getRight() != null) {
            return isFull(root.getLeft()) && isFull(root.getRight());
        }
        return false;
    }

    public int depth() {
        return depth(root);
    }

    private int depth(Node<T> root) {
        if (root == null) {
            return -1;
        }
        return Math.max(depth(root.getLeft()), depth(root.getRight())) + 1;
    }

    public boolean isPerfectTree() {
        return isPerfectTree(root, depth(root), 0);
    }

    private boolean isPerfectTree(Node<T> root, int maxDepth, int currentLevel) {
        if (root == null) {
            return true;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return maxDepth == currentLevel;
        }

        if (root.getLeft() == null || root.getRight() == null) {
            return false;
        }

        return isPerfectTree(root.getLeft(), maxDepth, currentLevel + 1)
                && isPerfectTree(root.getRight(), maxDepth, currentLevel + 1);
    }

    public boolean isCompleteTree() {
        return false;
    }
}
