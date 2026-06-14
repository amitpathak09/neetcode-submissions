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
    public TreeNode invertTree(TreeNode root) {

        if(root==null) {
            return root;
        }
        if(!hasChild(root)) {
            return root;
        } 
        if((root.left==null || !hasChild(root.left)) &&
         (root.right==null || !hasChild(root.right))) {
            return exchangeChild(root);
        } else {
            invertTree(root.left);
            invertTree(root.right);
            return exchangeChild(root);
        }
        
    }

    boolean hasChild(TreeNode root) {
        if(root==null) return false;
        if(root.left == null && root.right == null) return false;
        return true;
    }

    TreeNode exchangeChild(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
