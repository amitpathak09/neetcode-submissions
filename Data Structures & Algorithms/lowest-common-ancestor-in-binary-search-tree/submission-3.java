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

        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode result = root;
        queue.offer(root);
        while(!queue.isEmpty()) {
            //boolean isStillMatch = false;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                if(curr.left!=null && containsNode(curr.left, p) && containsNode(curr.left, q)) {
                    result = curr.left;
                    queue.offer(curr.left);
                    break;
                } else if(curr.right!=null && containsNode(curr.right, p) && containsNode(curr.right, q)) {
                    result = curr.right;
                    queue.offer(curr.right);
                    break;
                }
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
