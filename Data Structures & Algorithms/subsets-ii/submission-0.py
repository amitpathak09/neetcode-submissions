class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        
        def dfs(index, subsets):
          
            res.append(subsets.copy())

            for i in range(index, len(nums)):
            
                if i>index and nums[i]==nums[i-1]:
                    continue
                
                subsets.append(nums[i])
                dfs(i+1, subsets)
                subsets.pop()

        dfs(0,[])
        return res
            
        