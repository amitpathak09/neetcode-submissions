class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        
        candidates.sort()
        def dfs(i, remainingSum, subset):
            if remainingSum == 0:
                res.append(subset.copy())
                return

            for index in range(i, len(candidates)):
                if index>i and candidates[index]==candidates[index-1]:
                    continue

                if candidates[index]>remainingSum:
                    break
                
                subset.append(candidates[index])
                dfs(index+1, remainingSum-candidates[index], subset)
                subset.pop()
            

        dfs(0, target, [])
        return res
            
            

