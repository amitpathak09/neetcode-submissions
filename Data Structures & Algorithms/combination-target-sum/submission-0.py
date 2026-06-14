class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:

        res = []

        def dfs(i, sum, subset):
            if sum==0:
                res.append(subset.copy())
                return
            if i>=len(nums) or sum<0:
                return

            subset.append(nums[i])
            dfs(i, sum-nums[i], subset)

            subset.pop()
            dfs(i+1, sum, subset)

        dfs(0, target, [])
        return res
        