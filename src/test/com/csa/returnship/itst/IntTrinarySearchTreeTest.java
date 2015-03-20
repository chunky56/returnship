package com.csa.returnship.itst;

import com.csa.returnship.itst.IntTrinarySearchTree;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntTrinarySearchTreeTest {

    @Test
    public void testInsert() throws Exception {
        IntTrinarySearchTree tree = new IntTrinarySearchTree();

        assertEquals("", tree.toString());

        tree.insert(5);
        tree.insert(4);
        tree.insert(9);
        tree.insert(5);
        tree.insert(7);
        tree.insert(2);
        tree.insert(2);

        assertEquals("5,4,5,9,2,7,2,", tree.toString());
    }

    @Test
    public void testDelete() throws Exception {
        IntTrinarySearchTree tree = new IntTrinarySearchTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(9);
        tree.insert(5);
        tree.insert(7);
        tree.insert(1);
        tree.insert(2);

        assertEquals("5,3,5,9,1,7,2,", tree.toString());
        tree.delete(6); // Test item not found
        assertEquals("5,3,5,9,1,7,2,", tree.toString());
        tree.delete(7); // Test left child leaf
        assertEquals("5,3,5,9,1,2,", tree.toString());
        tree.delete(2); // Test right child leaf
        assertEquals("5,3,5,9,1,", tree.toString());
        tree.delete(5); // Test middle child leaf
        assertEquals("5,3,9,1,", tree.toString());
        tree.insert(2);
        tree.delete(1); // Test single right child
        assertEquals("5,3,9,2,", tree.toString());
        tree.insert(10);
        tree.insert(12);
        tree.delete(10); // Test single right child
        assertEquals("5,3,9,2,12,", tree.toString());
        tree.insert(1);
        tree.delete(2); // Test single left child
        assertEquals("5,3,9,1,12,", tree.toString());
        tree.insert(11);
        tree.delete(12); // Test single left child
        assertEquals("5,3,9,1,11,", tree.toString());
        tree.insert(4);
        tree.delete(3); // Test both children, successor is right child
        assertEquals("5,4,9,1,11,", tree.toString());
        tree.insert(8);
        tree.insert(10);
        tree.insert(10);
        tree.delete(9); // Test both children, successor is left child
        assertEquals("5,4,10,1,8,10,11,", tree.toString());
        tree.delete(8);
        tree.delete(5); // Test head with both children and successor has middle child
        assertEquals("10,4,10,11,1,", tree.toString());
        tree.delete(10);
        tree.delete(4);
        tree.delete(10); // Test head with both children
        assertEquals("11,1,", tree.toString());
        tree.delete(11); // Test head with left child
        assertEquals("1,", tree.toString());
        tree.insert(2); // Test head with right child
        tree.delete(1); // Test head with right child
        assertEquals("2,", tree.toString());
        tree.delete(2); // Test head with no children
        assertEquals("", tree.toString());
        tree.delete(1); // Test empty tree
        assertEquals("", tree.toString());
    }
}