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
    PriorityQueue<Integer> pq;
    public int kthSmallest(TreeNode root, int k) {
        this.pq = new PriorityQueue<>();
        traverse(root);
        if(k>pq.size()) return -1;
        int t=1;
        int res=0;
        while(t<=k) {
            res=pq.poll();
            t++;
        }
        return res;
    }
    
    private void traverse(TreeNode root) {
        if(root!=null) {
            this.pq.add(root.val);
        } else {
            return;
        }

        traverse(root.left);
        traverse(root.right);
    }
}
