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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder subRootSB = new StringBuilder();
        getTreeString(subRoot, subRootSB);
        String subRootString = subRootSB.toString();
        return isMatch(root, subRootString);
    }

    private boolean isMatch(TreeNode curr, String subRootString) {
        StringBuilder sb = new StringBuilder();
        getTreeString(curr, sb);
        if(sb.toString().equals(subRootString)) {
            return true;
        }

        if(curr==null) {
            return false;
        }

        //left check
        if(isMatch(curr.left, subRootString)) {
            return true;
        }

        //right check
        if(isMatch(curr.right, subRootString)) {
            return true;
        }
        return false;
    }

    private void getTreeString(TreeNode root, StringBuilder sb) {
        if(root==null) {
            sb.append("#");
            return;
        } 
        getTreeString(root.left, sb);
        sb.append(root.val);
        getTreeString(root.right, sb);
    }
}
