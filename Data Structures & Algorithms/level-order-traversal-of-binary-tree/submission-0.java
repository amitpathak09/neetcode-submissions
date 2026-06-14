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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lot = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root==null) return lot;
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                nodes.add(temp);
                level.add(temp.val);
            }
            lot.add(level);

            for(TreeNode node: nodes) {
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }
        return lot;
        
    }
}
