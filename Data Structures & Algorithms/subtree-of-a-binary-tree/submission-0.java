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
        ArrayList<Integer> srFlattened = new ArrayList<>();
        flattenTree(subRoot, srFlattened);
        return matchSubroot(root, srFlattened);
    }

    private boolean matchSubroot(TreeNode root, ArrayList<Integer> srFlattened) {
        ArrayList<Integer> flat = new ArrayList<>();
        boolean isEqual = srFlattened.equals(flattenTree(root, flat));
        if(isEqual || root==null) return isEqual;
        return (matchSubroot(root.left, srFlattened)||matchSubroot(root.right, srFlattened));

    }

    ArrayList<Integer> flattenTree(TreeNode root, ArrayList<Integer> ints) {
        if(root==null) {
            ints.add(1000);
            return ints;
        }
        flattenTree(root.left, ints);
        ints.add(root.val);
        flattenTree(root.right, ints);
        return ints;
    }
}
