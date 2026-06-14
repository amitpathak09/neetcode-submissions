class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        nums.sort()
        longestSequence = 1
        currentSequence = 1
        print(nums)
        for i in range(len(nums)):
            if i>0:
                if nums[i]==nums[i-1]+1:
                    currentSequence+=1
                elif nums[i]==nums[i-1]:
                    continue
                else:
                    currentSequence=1                

            if currentSequence>longestSequence:
                longestSequence = currentSequence

            print(nums[i], currentSequence, longestSequence)
        return longestSequence