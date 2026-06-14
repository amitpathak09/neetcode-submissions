class Solution:
    def findMin(self, nums: List[int]) -> int:
        n=len(nums)

        #0123456 -> 5601234

        

        def poi(l, r):
            if l>=r:
                return l
            mid=(l+r)//2
            if nums[mid]<nums[mid-1] and nums[mid]<nums[mid+1]:
                return mid
            elif nums[mid]>nums[r]:
                return poi(mid+1,r)
            elif nums[mid]<nums[r]:
                return poi(l,mid)

        l,r=0,n-1
        return nums[poi(l,r)]