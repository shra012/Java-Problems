package com.shra012.cracking.coding.interview.tree;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class BinaryTreeTests {

    private BinaryTree<Character> characterTree;

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
    void shouldReturnItemsInBreadthFirst() {
        List<Character> list = characterTree.breadthFirst();
        Assertions.assertEquals(List.of('A', 'B', 'C', 'D', 'E', 'F', 'H', 'G', 'I'), list);
    }

    @Test
    void shouldReturnItemsWithInOrderTraversalStrategy() {
        List<Character> direct = characterTree.inOrderTraversal();
        List<Character> recursion = characterTree.inOrderTraversalWithRecursion();
        Assertions.assertEquals(List.of('B', 'A', 'F', 'D', 'H', 'C', 'E', 'G', 'I'), direct);
        Assertions.assertEquals(List.of('B', 'A', 'F', 'D', 'H', 'C', 'E', 'G', 'I'), recursion);
    }

    @Test
    void shouldReturnItemsWithPerOrderTraversalStrategy() {
        List<Character> direct = characterTree.preOrderTraversal();
        List<Character> recursion = characterTree.preOrderTraversalWithRecursion();
        Assertions.assertEquals(List.of('A', 'B', 'C', 'D', 'F', 'H', 'E', 'G', 'I'), direct);
        Assertions.assertEquals(List.of('A', 'B', 'C', 'D', 'F', 'H', 'E', 'G', 'I'), recursion);
    }

    @Test
    void shouldReturnItemsWithPostOrderTraversalStrategy() {
        List<Character> direct = characterTree.postOrderTraversal();
        List<Character> recursion = characterTree.postOrderTraversalWithRecursion();
        Assertions.assertEquals(List.of('B', 'F', 'H', 'D', 'I', 'G', 'E', 'C', 'A'), direct);
        Assertions.assertEquals(List.of('B', 'F', 'H', 'D', 'I', 'G', 'E', 'C', 'A'), recursion);
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
        List<Character> mirroredList = characterTree.breadthFirst();
        Assertions.assertEquals(List.of('A', 'C', 'B', 'E', 'D', 'G', 'H', 'F', 'I'), mirroredList);
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
