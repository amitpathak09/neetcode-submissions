class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res=[0]*len(nums)
        rightProduct=[1]*len(nums)
        leftProduct=[1]*len(nums)

        for i in range(1, len(nums)):
            leftProduct[i]=leftProduct[i-1]*nums[i-1]

        for j in range(len(nums)-2, -1, -1):
            rightProduct[j]=rightProduct[j+1]*nums[j+1]

        for k in range(len(nums)):
            if k==0:
                res[k]=rightProduct[k]
            elif k==len(nums)-1:
                res[k]=leftProduct[k]
            else:
                res[k]=leftProduct[k]*rightProduct[k]

        return res


