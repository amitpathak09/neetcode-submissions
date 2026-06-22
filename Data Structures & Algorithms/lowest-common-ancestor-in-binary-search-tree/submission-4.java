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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //level order traversal 

        TreeNode result = root;
        while(result!=null && containsNode(result, p) && containsNode(result, q)) {
            TreeNode curr = result;
            if(containsNode(curr.left, p) && containsNode(curr.left, q)) {
                result = curr.left;
            } else if(containsNode(curr.right, p) && containsNode(curr.right, q)) {
                result = curr.right;
            } else {
                break;
            }
        }
        return result;
    }

    // returns true if the node contains given node, or else false;

    private boolean containsNode(TreeNode root, TreeNode target) {
        //preorder traversal

        if(root==null) return false;
        if(root.val==target.val) return true;

        return containsNode(root.left, target) || containsNode(root.right, target);

    }
}
