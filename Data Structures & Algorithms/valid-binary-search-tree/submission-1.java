/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;

        return checkBST(root.left, root.val, Integer.MIN_VALUE) && checkBST(root.right, Integer.MAX_VALUE, root.val);
    }

    private boolean checkBST(TreeNode root, int maxVal, int minVal) {
        if(root==null) return true;
        if(root.val <=minVal || root.val >= maxVal) return false;
        return checkBST(root.left, root.val, minVal) && checkBST(root.right, maxVal, root.val);
    }
}
