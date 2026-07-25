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
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode root, int maxVal) {
        if(root==null) {
            return 0;
        }
        int total = 0;
        if(root.val>=maxVal) {
            total+=1;
        }

        int mv = Math.max(maxVal, root.val);

        total+=countGoodNodes(root.left, mv);
        total+=countGoodNodes(root.right, mv);

        return total;
    }
 
}
