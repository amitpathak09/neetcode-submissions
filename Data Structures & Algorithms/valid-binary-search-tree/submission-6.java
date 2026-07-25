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
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, int min, int max) {
        if(root==null) {
            return true;
        }

        if(root.left!=null) {
            if(root.left.val<root.val && root.left.val>min && root.left.val<max) {
                if(!checkBST(root.left, min, root.val)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if(root.right!=null) {
            if(root.right.val>root.val && root.right.val<max && root.right.val>min) {
                if(!checkBST(root.right, root.val, max)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
