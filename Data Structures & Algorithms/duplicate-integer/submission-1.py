class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        nums.sort()
        length = len(nums)
        if length==0 or length==1:
            return False
        nums.sort()
        for i in range(1,length):
            if(nums[i]==nums[i-1]):
                return True

        return False