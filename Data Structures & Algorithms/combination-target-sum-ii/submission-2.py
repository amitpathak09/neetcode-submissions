class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        hashset = set()
        candidates.sort()

        def dfs(index, remainingSum, subset):
            if remainingSum == 0:
                hashset.add(tuple(subset.copy()))
                return
            if remainingSum < 0:
                return

            for i in range(index, len(candidates)):
                
                subset.append(candidates[i])
                dfs(i+1, remainingSum-candidates[i], subset)
                subset.pop()
        
        dfs(0, target, [])
        return [list(combination) for combination in hashset]
