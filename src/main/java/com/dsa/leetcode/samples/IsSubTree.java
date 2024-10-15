package com.dsa.leetcode.samples;

public class IsSubTree {

	public static void main(String[] args) {

	}

	private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot != null && root.val == subRoot.val) {
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        }
        return false;
    }

}
