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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0 || inorder.length != preorder.length) {
            return null;
        }
        return processInorder(0, 0, inorder.length, preorder, inorder);
        
    }

    //root is the index of root in the preorder array, left and right are boundaries of the tree in inorder array
    TreeNode processInorder(int root, int left, int right, int[] preorder, int[] inorder) {
        int idx = 0;

        if(left>right-1) return null;

        if(left==right-1) return new TreeNode(inorder[left]);

        for(int i=left; i<right; i++) {
            if(inorder[i]==preorder[root]) {
                idx = i;
                System.out.println(idx);
                break;
            }
        }

        TreeNode lt = processInorder(root+1, left, idx, preorder, inorder);

        TreeNode mid = new TreeNode(preorder[root]);

        TreeNode rt = processInorder(root+(idx-left+1), idx+1, right, preorder, inorder);

        mid.left=lt;
        mid.right=rt;
        return mid;
    }
}
