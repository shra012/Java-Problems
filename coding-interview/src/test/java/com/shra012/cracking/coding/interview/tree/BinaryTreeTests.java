package com.shra012.cracking.coding.interview.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

@Slf4j
class BinaryTreeTests {

    private BinaryTree<Character> characterTree;

    private static final BinaryTree<Character> EMPTY = new BinaryTree<>(null);

    @BeforeEach
    void setUp() {
        Node<Character> root = new Node<>('A');
        root.setLeft(new Node<>('B'));
        root.setRight(new Node<>('C'));
        root.getRight().setLeft(new Node<>('D'));
        root.getRight().setRight(new Node<>('E'));
        root.getRight().getLeft().setLeft(new Node<>('F'));
        root.getRight().getLeft().setRight(new Node<>('H'));
        root.getRight().getRight().setRight(new Node<>('G'));
        root.getRight().getRight().getRight().setRight(new Node<>('I'));
        characterTree = new BinaryTree<>(root);
        log.info("{}", characterTree);
    }

    @Test
    void nodeToStringShouldReturnTheElement() {
        Node<Character> root = new Node<>('A');
        Assertions.assertEquals("A", root.toString());
        Node<Character> NULL_NODE = new Node<>(null);
        Assertions.assertNull(NULL_NODE.toString());
    }

    @Test
    void shouldReturnItemsInBreadthFirst() {
        List<Character> list = characterTree.breadthFirst();
        Assertions.assertEquals(List.of('A', 'B', 'C', 'D', 'E', 'F', 'H', 'G', 'I'), list);
    }

    @Test
    void shouldReturnEmptyListWhenNodeIsNullOnBreadthFirst() {
        List<Character> list = EMPTY.breadthFirst();
        Assertions.assertEquals(Collections.EMPTY_LIST, list);
    }

    @Test
    void shouldReturnItemsWithInOrderTraversalStrategy() {
        List<Character> direct = characterTree.inOrderTraversal();
        List<Character> recursion = characterTree.inOrderTraversalWithRecursion();
        Assertions.assertEquals(List.of('B', 'A', 'F', 'D', 'H', 'C', 'E', 'G', 'I'), direct);
        Assertions.assertEquals(List.of('B', 'A', 'F', 'D', 'H', 'C', 'E', 'G', 'I'), recursion);
    }

    @Test
    void shouldReturnEmptyListWhenNodeIsNullOnInOrderTraversal() {
        List<Character> list = EMPTY.inOrderTraversal();
        Assertions.assertEquals(Collections.EMPTY_LIST, list);
    }

    @Test
    void shouldReturnItemsWithPerOrderTraversalStrategy() {
        List<Character> direct = characterTree.preOrderTraversal();
        List<Character> recursion = characterTree.preOrderTraversalWithRecursion();
        Assertions.assertEquals(List.of('A', 'B', 'C', 'D', 'F', 'H', 'E', 'G', 'I'), direct);
        Assertions.assertEquals(List.of('A', 'B', 'C', 'D', 'F', 'H', 'E', 'G', 'I'), recursion);
    }

    @Test
    void shouldReturnEmptyListWhenNodeIsNullOnPreOrderTraversal() {
        List<Character> list = EMPTY.preOrderTraversal();
        Assertions.assertEquals(Collections.EMPTY_LIST, list);
    }

    @Test
    void shouldReturnItemsWithPostOrderTraversalStrategy() {
        List<Character> direct = characterTree.postOrderTraversal();
        List<Character> recursion = characterTree.postOrderTraversalWithRecursion();
        Assertions.assertEquals(List.of('B', 'F', 'H', 'D', 'I', 'G', 'E', 'C', 'A'), direct);
        Assertions.assertEquals(List.of('B', 'F', 'H', 'D', 'I', 'G', 'E', 'C', 'A'), recursion);
    }

    @Test
    void shouldReturnEmptyListWhenNodeIsNullOnPostOrderTraversal() {
        List<Character> list = EMPTY.postOrderTraversal();
        Assertions.assertEquals(Collections.EMPTY_LIST, list);
    }

    @Test
    void shouldCountAllNodes() {
        int nodes = characterTree.nodes();
        Assertions.assertEquals(9, nodes);
    }

    @Test
    void shouldFindTheMaximumDepthOfTheBinaryTree() {
        int maxDepth = characterTree.maxDepth();
        Assertions.assertEquals(4, maxDepth);
    }

    @Test
    void shouldMirrorTheCurrentTree() {
        characterTree.mirror();
        log.info("- {} -", characterTree);
        List<Character> mirroredList = characterTree.breadthFirst();
        Assertions.assertEquals(List.of('A', 'C', 'B', 'E', 'D', 'G', 'H', 'F', 'I'), mirroredList);
    }

    @Test
    void shouldTestPathSum() {
        Node<Integer> root = new Node<>(1);
        root.setLeft(new Node<>(2));
        root.setRight(new Node<>(3));
        root.getRight().setLeft(new Node<>(7));
        root.getRight().setRight(new Node<>(6));
        root.getRight().getLeft().setLeft(new Node<>(8));
        root.getRight().getRight().setLeft(new Node<>(5));
        root.getRight().getRight().setRight(new Node<>(4));
        BinaryTree<Integer> integerTree = new BinaryTree<>(root);
        Assertions.assertTrue(integerTree.hasPathSum(15));
        Assertions.assertFalse(integerTree.hasPathSum(12));
        Assertions.assertTrue(integerTree.hasPathSumSubtraction(3));
        Assertions.assertFalse(integerTree.hasPathSumSubtraction(5));
    }

    @Test
    void shouldThrowIllegalStateExceptionWhenHasPathSumIsCalledWithANonNumericTree() {
        Assertions.assertThrows(IllegalStateException.class, () -> characterTree.hasPathSum(1));
        Assertions.assertThrows(IllegalStateException.class, () -> characterTree.hasPathSumSubtraction(1));
    }

    @Test
    void shouldReturnTrueWhenTheTreeIsFull() {
        Node<Character> root = buildFullTreeNodes();
        BinaryTree<Character> fullTree = new BinaryTree<>(root);
        Assertions.assertTrue(fullTree.isFull());
    }

    @Test
    void shouldReturnFalseWhenTheTreeIsNotFull() {
        Node<Character> root = buildFullTreeNodes();
        root.getRight().getRight().setLeft(null);
        BinaryTree<Character> fullTree = new BinaryTree<>(root);
        Assertions.assertFalse(fullTree.isFull());
    }

    @Test
    void shouldReturnTrueWhenTheTreeIsPerfect() {
        Node<Character> root = new Node<>('A');
        root.setLeft(new Node<>('B'));
        root.getLeft().setLeft(new Node<>('D'));
        root.getLeft().setRight(new Node<>('E'));
        root.setRight(new Node<>('C'));
        root.getRight().setLeft(new Node<>('F'));
        root.getRight().setRight(new Node<>('G'));
        BinaryTree<Character> perfectTree = new BinaryTree<>(root);
        Assertions.assertTrue(perfectTree.isPerfectTree());
    }

    @Test
    void shouldReturnFalseWhenTheTreeIsNotPerfect() {
        Assertions.assertFalse(characterTree.isPerfectTree());
    }

    @Test
    void shouldReturnTrueWhenTheTreeIsComplete() {
        Node<Character> root = new Node<>('A');
        root.setLeft(new Node<>('B'));
        root.getLeft().setLeft(new Node<>('D'));
        root.getLeft().setRight(new Node<>('E'));
        root.setRight(new Node<>('C'));
        root.getRight().setLeft(new Node<>('F'));
        root.getRight().setRight(new Node<>('G'));
        BinaryTree<Character> completeTree = new BinaryTree<>(root);
        Assertions.assertTrue(completeTree.isCompleteTree());
        root.getLeft().getLeft().setLeft(new Node<>('H'));
        root.getLeft().getLeft().setRight(new Node<>('I'));
        root.getLeft().getRight().setLeft(new Node<>('J'));
        Assertions.assertTrue(completeTree.isCompleteTree());
        root.getRight().getLeft().setLeft(new Node<>('L'));
        Assertions.assertFalse(completeTree.isCompleteTree());
    }

    @Test
    void shouldReturnTrueWhenTheTreeIsBalanced() {
        Node<Character> root = new Node<>('A');
        root.setLeft(new Node<>('B'));
        root.setRight(new Node<>('C'));
        root.getRight().setLeft(new Node<>('D'));
        root.getRight().setRight(new Node<>('E'));
        BinaryTree<Character> balancedTree = new BinaryTree<>(root);
        Assertions.assertTrue(balancedTree.isBalancedTree());
        root.getRight().getLeft().setRight(new Node<>('F'));
        Assertions.assertFalse(balancedTree.isBalancedTree());
    }

    private Node<Character> buildFullTreeNodes() {
        Node<Character> root = new Node<>('A');
        root.setLeft(new Node<>('B'));
        root.setRight(new Node<>('C'));
        root.getRight().setLeft(new Node<>('D'));
        root.getRight().setRight(new Node<>('E'));
        root.getRight().getLeft().setLeft(new Node<>('F'));
        root.getRight().getLeft().setRight(new Node<>('H'));
        root.getRight().getRight().setRight(new Node<>('G'));
        root.getRight().getRight().getRight().setRight(new Node<>('I'));
        root.getRight().getRight().setLeft(new Node<>('J'));
        root.getRight().getRight().getRight().setLeft(new Node<>('K'));
        return root;
    }
}
