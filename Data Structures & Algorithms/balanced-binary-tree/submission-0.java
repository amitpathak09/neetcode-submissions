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
    public boolean isBalanced(TreeNode root) {
        //we need to do post order traversal
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;

        if(isBalanced(root.left)==false) return false;
        if(isBalanced(root.right)==false) return false;

        int heightDiff = treeHeight(root.left)-treeHeight(root.right);
        if(heightDiff>1||heightDiff<-1) return false;

        return true;

    }

    private int treeHeight(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(treeHeight(root.left), treeHeight(root.right));
    }
}