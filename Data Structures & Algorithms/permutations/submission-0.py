class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.backtrack([], nums, [False]*len(nums))
        return self.res

    def backtrack(self, perm: List[int], nums: List[int], visited: List[bool]):
        if len(perm) == len(nums):
            self.res.append(perm.copy())
            return
        for i in range(len(nums)):
            if(not visited[i]):
                perm.append(nums[i])
                visited[i]=True
                self.backtrack(perm, nums, visited)
                perm.pop()
                visited[i]=False

        