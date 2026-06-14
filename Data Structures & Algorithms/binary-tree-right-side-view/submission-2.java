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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ints = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        //for stack push and poll, for queue offer, poll
        if(root==null) return ints;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i=1; i<=levelSize; i++) {
                TreeNode node = queue.poll();
                if(node.left !=null) queue.offer(node.left);
                if(node.right !=null) queue.offer(node.right);
                if(i==levelSize) {
                    ints.add(node.val);
                }
            }
        }
        return ints;
    }
}
