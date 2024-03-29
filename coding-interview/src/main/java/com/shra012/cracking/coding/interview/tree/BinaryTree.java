package com.shra012.cracking.coding.interview.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Basic Binary Tree Implementation.
 */
public final class BinaryTree<T extends Comparable<T>> {
    private final Node<T> root;

    /**
     * The user of this binary has to build the nodes before they can access the
     * methods in this class.
     * 
     * @param node
     *            - the root tree node.
     */
    public BinaryTree(Node<T> node) {
        this.root = node;
    }

    /**
     * To string prints the binary tree.
     */
    @Override
    public String toString() {
        return "Binary Tree\n" + root.printTree();
    }

    /**
     * Collects and returns a list which is order based on the breadth first data
     * of the tree.
     * 
     * Consider the tree below which has 9 nodes, breadth first traversal would
     * return [ 'A', 'B', 'C', 'D', 'E', 'F', 'H', 'G', 'I' ].
     * 
     * <pre>
     * Example : 
     *    │               ┌── I
     *    │           ┌── G
     *    │       ┌── E
     *    │   ┌── C
     *    │   │   │   ┌── H
     *    │   │   └── D
     *    │   │       └── F
     *    └── A
     *        └── B
     * </pre>
     * 
     * @return A list which has the data of nodes collected in breadth first manner.
     */
    public List<T> breadthFirst() {
        List<T> list = new LinkedList<>();
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

    /**
     * Collects and returns a list which is order by traversing the tree in order.
     * 
     * Consider the tree below which has 9 nodes, in order traversal would
     * return [ 'B', 'A', 'F', 'D', 'H', 'C', 'E', 'G', 'I' ].
     * 
     * <pre>
     * Example : 
     *    │               ┌── I
     *    │           ┌── G
     *    │       ┌── E
     *    │   ┌── C
     *    │   │   │   ┌── H
     *    │   │   └── D
     *    │   │       └── F
     *    └── A
     *        └── B
     * </pre>
     * 
     * @return A list which has the data of nodes collected in order.
     */
    public List<T> inOrderTraversal() {
        List<T> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Set<Node<T>> visited = new HashSet<>();
        Deque<Node<T>> stack = new ArrayDeque<>();
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

    /**
     * Collects and returns a list which is order by traversing the tree in order
     * using recursion.
     * 
     * Consider the tree below which has 9 nodes, in order traversal would
     * return [ 'B', 'A', 'F', 'D', 'H', 'C', 'E', 'G', 'I' ].
     * 
     * <pre>
     * Example :
     * │ ┌── I
     * │ ┌── G
     * │ ┌── E
     * │ ┌── C
     * │ │ │ ┌── H
     * │ │ └── D
     * │ │ └── F
     * └── A
     * └── B
     * 
     * <pre>
     * 
     * @return A list which has the data of nodes collected in order.
     */
    public List<T> inOrderTraversalWithRecursion() {
        List<T> list = new LinkedList<>();
        inOrderTraversalWithRecursion(root, list);
        return list;
    }

    /**
     *
     * Recursively populates the list which is order by traversing the tree in
     * order.
     * 
     * @param root
     *            - the root node of the tree.
     * @param list
     *            - list which collects the data in the tree in order.
     */
    private void inOrderTraversalWithRecursion(Node<T> root, List<T> list) {
        if (root == null) {
            return;
        }
        inOrderTraversalWithRecursion(root.getLeft(), list);
        list.add(root.getData());
        inOrderTraversalWithRecursion(root.getRight(), list);
    }

    /**
     * Collects and returns a list which is order by traversing the tree pre order.
     * 
     * Consider the tree below which has 9 nodes, per order traversal would
     * return [ 'A', 'B', 'C', 'D', 'F', 'H', 'E', 'G', 'I' ].
     * 
     * <pre>
     * Example : 
     *    │               ┌── I
     *    │           ┌── G
     *    │       ┌── E
     *    │   ┌── C
     *    │   │   │   ┌── H
     *    │   │   └── D
     *    │   │       └── F
     *    └── A
     *        └── B
     * </pre>
     * 
     * @return A list which has the data of nodes collected pre order.
     */
    public List<T> preOrderTraversal() {
        List<T> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Set<Node<T>> visited = new HashSet<>();
        Deque<Node<T>> stack = new ArrayDeque<>();
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

    /**
     * Collects and returns a list which is order by traversing the tree pre order
     * using recursion.
     * 
     * Consider the tree below which has 9 nodes, per order traversal would
     * return [ 'A', 'B', 'C', 'D', 'F', 'H', 'E', 'G', 'I' ].
     * 
     * <pre>
     * Example : 
     *    │               ┌── I
     *    │           ┌── G
     *    │       ┌── E
     *    │   ┌── C
     *    │   │   │   ┌── H
     *    │   │   └── D
     *    │   │       └── F
     *    └── A
     *        └── B
     * </pre>
     * 
     * @return A list which has the data of nodes collected pre order.
     */
    public List<T> preOrderTraversalWithRecursion() {
        List<T> list = new LinkedList<>();
        preOrderTraversalWithRecursion(root, list);
        return list;
    }

    /**
     *
     * Recursively populates the list which is order by traversing the tree pre
     * order.
     *
     * @param root
     *            - the root node of the tree.
     * @param list
     *            - list which collects the data in the tree pre order.
     */
    private void preOrderTraversalWithRecursion(Node<T> root, List<T> list) {
        if (root == null) {
            return;
        }
        list.add(root.getData());
        preOrderTraversalWithRecursion(root.getLeft(), list);
        preOrderTraversalWithRecursion(root.getRight(), list);
    }

    /**
     * Collects and returns a list which is order by traversing the tree post order.
     * 
     * Consider the tree below which has 9 nodes, post order traversal would
     * return [ 'B', 'F', 'H', 'D', 'I', 'G', 'E', 'C', 'A' ].
     * 
     * <pre>
     * Example : 
     *    │               ┌── I
     *    │           ┌── G
     *    │       ┌── E
     *    │   ┌── C
     *    │   │   │   ┌── H
     *    │   │   └── D
     *    │   │       └── F
     *    └── A
     *        └── B
     * </pre>
     * 
     * @return A list which has the data of nodes collected post order.
     */
    public List<T> postOrderTraversal() {
        List<T> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Set<Node<T>> visited = new HashSet<>();
        Deque<Node<T>> stack = new ArrayDeque<>();
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

    /**
     * Collects and returns a list which is order by traversing the tree post order
     * using recursion.
     * 
     * Consider the tree below which has 9 nodes, post order traversal would
     * return [ 'B', 'F', 'H', 'D', 'I', 'G', 'E', 'C', 'A' ].
     * 
     * <pre>
     * Example : 
     *    │               ┌── I
     *    │           ┌── G
     *    │       ┌── E
     *    │   ┌── C
     *    │   │   │   ┌── H
     *    │   │   └── D
     *    │   │       └── F
     *    └── A
     *        └── B
     * </pre>
     * 
     * @return A list which has the data of nodes collected post order.
     */
    public List<T> postOrderTraversalWithRecursion() {
        List<T> list = new LinkedList<>();
        postOrderTraversalWithRecursion(root, list);
        return list;
    }

    /**
     *
     * Recursively populates the list which is order by traversing the tree post
     * order.
     *
     * @param root
     *            - the root node of the tree.
     * @param list
     *            - list which collects the data in the tree post order.
     */
    private void postOrderTraversalWithRecursion(Node<T> root, List<T> list) {
        if (root == null) {
            return;
        }
        postOrderTraversalWithRecursion(root.getLeft(), list);
        postOrderTraversalWithRecursion(root.getRight(), list);
        list.add(root.getData());
    }

    /**
     * computes all the nodes of a binary tree.
     * 
     * @return a integer representing the count of all the nodes in the tree.
     */
    public int nodes() {
        return nodes(root);
    }

    /**
     * computes all the nodes of a binary tree.
     * 
     * @param root
     *            - root node.
     * @return a integer representing the count of all the nodes in the tree.
     */
    private int nodes(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return nodes(root.getLeft()) + nodes(root.getRight()) + 1;
    }

    /**
     * finds the depth of the binary tree
     * 
     * @return a integer which determines how deep the tree is.
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    /**
     * finds the depth of the binary tree
     * 
     * @param root
     *            - root node.
     * @return a integer which determines how deep the tree is.
     */
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

    /**
     * Checks if a numeric tree's path sum has the given value.
     * 
     * @param sum
     *            - expected path sum
     * 
     * @return - true if the sum given exists when for a branch in the tree
     *         by adding the data of all nodes.
     */
    public boolean hasPathSum(int sum) {
        if (Number.class.isAssignableFrom(root.getData().getClass())) {
            return hasPathSumRecursion(root, sum, 0);
        } else {
            throw new IllegalStateException("Called has path sum when the data is not instance of Number class");
        }
    }

    /**
     * Checks if a numeric tree's path sum has the given value.
     * 
     * @param root
     *            - root node.
     * @param expectedSum
     *            - expected path sum.
     * @param actualSum
     *            - actual sum.
     * @return - true if the sum given is the path's data summation.
     */
    private boolean hasPathSumRecursion(Node<T> root, Integer expectedSum, Integer actualSum) {
        if (root == null) {
            return false;
        }
        actualSum += ((Number) root.getData()).intValue();
        if (root.getLeft() == null && root.getRight() == null && expectedSum != 0) {
            return actualSum.equals(expectedSum);
        }
        return hasPathSumRecursion(root.getLeft(), expectedSum, actualSum)
                || hasPathSumRecursion(root.getRight(), expectedSum, actualSum);
    }

    /**
     * Checks if a numeric tree's path sum has the given value by subtracting
     * expected sum till the value matches any value of the leaf nodes.
     * 
     * @param sum
     *            - expected path sum
     * @return - true if the sum given exists when for a branch in the tree
     *         by subtraction of each data node along the path and matching the leaf
     *         value.
     */
    public boolean hasPathSumSubtraction(int sum) {
        if (Number.class.isAssignableFrom(root.getData().getClass())) {
            return hasPathSumSubtraction(root, sum);
        } else {
            throw new IllegalStateException("Called has path sum when the data is not instance of Number class");
        }
    }

    /**
     * Checks if a numeric tree's path sum has the given value by subtracting
     * expected sum till the value matches any value of the leaf nodes.
     * 
     * @param root
     *            - root node
     * @param sum
     *            - expected path sum
     * @return - true if the sum given exists when for a branch in the tree
     *         by subtraction of each data node along the path and matching the leaf
     *         value.
     */
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

    /**
     * 
     * Mirrors the give binary tree.
     * 
     * <pre>
     * Initial Tree
     * 
     *    │               ┌── I
     *    │           ┌── G
     *    │       ┌── E
     *    │   ┌── C
     *    │   │   │   ┌── H
     *    │   │   └── D
     *    │   │       └── F
     *    └── A
     *        └── B
     * </pre>
     * 
     * <pre>
     * Mirror Result:
     * 
     *  │    ┌── B
     *  └── A
     *      │       ┌── F
     *      │   ┌── D
     *      │   │   └── H
     *      └── C
     *          └── E
     *              └── G
     *                  └── I
     * </pre>
     */
    public void mirror() {
        mirror(root);
    }

    /**
     * Mirrors the give binary tree
     * 
     * @param root
     *            - root node
     */
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

    /**
     * Checks if a Binary Tree is Full.
     * 
     * <p>
     * A binary tree is considered full if one of
     * the below conditions are met
     * </p>
     * <ul>
     * <li>if every node has 0 or 2 children</li>
     * <li>all nodes except leaf nodes have two children</li>
     * </ul>
     * 
     * <p>
     * Mathematical relationships of a full binary tree
     * </p>
     * <ul>
     * <li>Number of leaves = Number of internal nodes + 1</li>
     * <li>Total nodes = 2 * Number of internal nodes + 1</li>
     * <li>Number of leaf nodes = (Total nodes + 1) / 2</li>
     * <li>Total nodes = 2 * Number of leaves - 1</li>
     * </ul>
     * 
     * <p>
     * Calls a private recursive method to perform computation
     * </p>
     * 
     * @return true if a binary tree is full.
     */
    public boolean isFull() {
        return isFull(root);
    }

    /**
     * Checks recursively if a Binary Tree is Full.
     * 
     * @param root
     *            - root node
     * @return true if a binary tree is full.
     */
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

    /**
     * Checks if a binary tree is perfect.
     * 
     * <p>
     * A binary tree is considered to be perfect if
     * all the below conditions are met.
     * </p>
     * <ul>
     * <li>all the internal nodes have two children</li>
     * <li>all leaf nodes are at the same level</li>
     * </ul>
     * 
     * <p>
     * Mathematical relationships of a full binary tree
     * </p>
     * <ul>
     * <li>Number of nodes = 2<sup>h+1</sup> - 1</li>
     * <li>Number of leaf nodes = 2 * h</li>
     * </ul>
     * <b>where h is the height of the binary tree</b>
     * 
     * <p>
     * Calls a private recursive method to perform computation
     * </p>
     * 
     * @return true if all the conditions for perfect binary tree is met.
     */
    public boolean isPerfectTree() {
        return isPerfectTree(root, maxDepth(root), 0);
    }

    /**
     * Checks recursively if a binary tree is perfect.
     * 
     * @param root
     *            - root node
     * @param maxDepth
     *            - max depth of binary tree
     * @param currentLevel
     *            - the current level of node that is being progressed
     * @return true if all the conditions for perfect binary tree is met.
     */
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

    /**
     * Checks if a binary tree is complete.
     * 
     * <p>
     * A binary tree is considered to be complete if
     * all the below conditions are met.
     * </p>
     * <ul>
     * <li>all the levels are completely filled except possibly the last level</li>
     * <li>the last level has all keys as left as possible</li>
     * </ul>
     * 
     * Mathematical relationships of a complete binary tree
     * </p>
     * <ul>
     * <li>Left child index = 2 * index of parent node + 1</li>
     * <li>Right child index = 2 * index of parent node + 2</li>
     * </ul>
     * <b>Index of the root node is zero.</b>
     * 
     * <p>
     * Calls a private recursive method to perform computation
     * </p>
     * 
     * @return true if all conditions for a complete binary tree are met.
     */
    public boolean isCompleteTree() {
        return isCompleteTree(root, 0, nodes(root));
    }

    /**
     * Checks recursively if a binary tree is complete.
     * 
     * @param root
     *            - root node
     * @param currNodeIndex
     *            - the index of the current node that is being progressed
     * @param totalNodes
     *            - the total number of nodes in a binary tree.
     * @return true if all conditions for a complete binary tree are met.
     */
    private boolean isCompleteTree(Node<T> root, int currNodeIndex, int totalNodes) {
        if (root == null) {
            return true;
        }

        if (currNodeIndex >= totalNodes) {
            return false;
        }

        int leftNodeIndex = 2 * currNodeIndex + 1;
        int rightNodeIndex = 2 * currNodeIndex + 2;

        return isCompleteTree(root.getLeft(), leftNodeIndex, totalNodes)
                && isCompleteTree(root.getRight(), rightNodeIndex, totalNodes);
    }

    /**
     * Checks if a binary tree is balanced.
     * 
     * <p>
     * A binary tree is considered to be balanced if
     * height of the left and right sub-tree of any
     * node differ no more than 1.
     * 
     * <p>
     * Calls a private recursive method to perform computation
     * </p>
     * 
     * @return true if the tree is balanced binary tree.
     */
    public boolean isBalancedTree() {
        return isBalancedTree(root, new HashMap<>());
    }

    /**
     * Checks recursively if a binary tree is balanced.
     * 
     * @param root
     *            - root node
     * @param nodeHeight
     *            - node height map which computes and contains all nodes height.
     * @return true if the tree is balanced binary tree.
     */
    private boolean isBalancedTree(Node<T> root, HashMap<Node<T>, Integer> nodeHeight) {
        if (root == null) {
            return true;
        }

        boolean isLeftBalanced = isBalancedTree(root.getLeft(), nodeHeight);
        boolean isRightBalanced = isBalancedTree(root.getRight(), nodeHeight);

        int leftHeight = nodeHeight.getOrDefault(root.getLeft(), 0);
        int rightHeight = nodeHeight.getOrDefault(root.getRight(), 0);

        nodeHeight.put(root, Math.max(leftHeight, rightHeight) + 1);

        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return isLeftBalanced && isRightBalanced;
        }

        return false;
    }
}
