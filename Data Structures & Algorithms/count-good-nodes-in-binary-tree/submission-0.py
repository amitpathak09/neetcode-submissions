# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        maxVal = -101

        def dfs(node, mv):
            count = 0
            if node is None:
                return count

            if mv<=node.val:
                mv=node.val
                count+=1
            
            count+=dfs(node.left, mv)
            
            count+=dfs(node.right, mv)
            return count
        
        return dfs(root, maxVal)
            



                

        