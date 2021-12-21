package com.shra012.cracking.coding.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class BinarySearchTreeTests {
    private BinarySearchTree<Integer> bst;
    private static final BinarySearchTree<Integer> EMPTY = new BinarySearchTree<>();

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
        bst.insert(null);
        bst.insert(8);
        bst.insert(3);
        bst.insert(6);
        bst.insert(1);
        bst.insert(4);
        bst.insert(7);
        bst.insert(10);
        bst.insert(14);
        bst.insert(13);
        log.info("{}", bst);
    }

    @Test
    void shouldInsertValuesByTheirNaturalOrder() {
        Assertions.assertEquals(9, bst.size());
    }

    @Test
    void shouldReturnTrueIfTheValueIsExistsInTheTree() {
        Assertions.assertTrue(bst.contains(3));
        Assertions.assertFalse(bst.contains(2));
    }

    @Test
    void shouldReturnMinimumValueInTheTree() {
        Assertions.assertEquals(1, bst.minimum());
        bst.insert(-10);
        Assertions.assertEquals(-10, bst.minimum());
        bst.insert(9);
        Assertions.assertEquals(-10, bst.minimum());
        Assertions.assertNull(EMPTY.minimum());
    }

    @Test
    void shouldReturnMaximumValueInTheTree() {
        Assertions.assertEquals(14, bst.maximum());
        bst.insert(20);
        Assertions.assertEquals(20, bst.maximum());
        bst.insert(-10);
        Assertions.assertEquals(20, bst.maximum());
        Assertions.assertNull(EMPTY.maximum());
    }

    @Test
    void shouldReturnAllDataBetweenASpecifiedRange() {
        Assertions.assertEquals(List.of(6, 7, 8, 10), bst.between(5, 10));
    }

    @Test
    void shouldReturnTrueIfBinaryTreeIsValid() {
        Assertions.assertTrue(bst.isValid());
        Assertions.assertEquals(List.of(1, 3, 4, 6, 7, 8, 10, 13, 14), bst.inOrder());
    }

    @Test
    void shouldReturnFalseIfBinaryTreeIsInValid() {
        bst.getRoot().getRight().getRight().setRight(new Node<>(12));
        Assertions.assertFalse(bst.isValid());
    }

    @Test
    void shouldReturnFalseIfBinaryTreeIsNotValid() {
        bst.getRoot().getRight().setLeft(new Node<>(15));
        Assertions.assertFalse(bst.isValid());
    }

}
