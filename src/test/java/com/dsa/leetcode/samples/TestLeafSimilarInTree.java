package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLeafSimilarInTree {

	private LeafSimilarInTree leafChecker;
	
	@BeforeEach
	void setUp() {
		leafChecker = new LeafSimilarInTree();
	}

    @Test
    public void testLeafSimilarTrueCase() {
        /*
            Tree 1:      3               Tree 2:       7
                        / \                           / \
                       5   1                         2   6
                      / \   \                           / \
                     6   2   9                         6   2
                         |
                         9

            Leaves Tree1: [6, 9, 9]
            Leaves Tree2: [6, 9, 9]
         */
        TreeNode root1 = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2, new TreeNode(9), null)),
                new TreeNode(1, null, new TreeNode(9))
        );

        TreeNode root2 = new TreeNode(7,
                new TreeNode(2),
                new TreeNode(6, new TreeNode(6), new TreeNode(2, new TreeNode(9), null))
        );

        assertFalse(leafChecker.leafSimilar(root1, root2));
    }

    @Test
    public void testLeafSimilarFalseCaseDifferentLeaves() {
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root2 = new TreeNode(1, new TreeNode(3), new TreeNode(2));
        assertFalse(leafChecker.leafSimilar(root1, root2));
    }

    @Test
    public void testLeafSimilarFalseCaseDifferentLeafCount() {
        TreeNode root1 = new TreeNode(1, new TreeNode(2), null);
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertFalse(leafChecker.leafSimilar(root1, root2));
    }

    @Test
    public void testLeafSimilarBothSingleLeafSame() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        assertTrue(leafChecker.leafSimilar(root1, root2));
    }

    @Test
    public void testLeafSimilarBothSingleLeafDifferent() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        assertFalse(leafChecker.leafSimilar(root1, root2));
    }

    @Test
    public void testLeafSimilarOneTreeNull() {
        TreeNode root1 = null;
        TreeNode root2 = new TreeNode(1);
        assertFalse(leafChecker.leafSimilar(root1, root2));
    }

    @Test
    public void testLeafSimilarBothTreesNull() {
        assertFalse(leafChecker.leafSimilar(null, null));
    }

}
