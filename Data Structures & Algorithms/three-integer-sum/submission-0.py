class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []

        def dfs(index, subset, remainingSum):
            if(len(subset)==3 and remainingSum==0):
                res.append(subset.copy())
                return
            if(len(subset)>=3):
                return
            
            for i in range(index, len(nums)):
                if i>index and nums[i-1]==nums[i]:
                    continue
                subset.append(nums[i])
                dfs(i+1, subset, remainingSum - nums[i])

                subset.pop()

        dfs(0, [], 0)

        return res
        