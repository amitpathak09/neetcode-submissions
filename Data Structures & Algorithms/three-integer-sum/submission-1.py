class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res=[]
        nums.sort()
        #print(nums)
        left, right = 0, len(nums)-1
        for i in range(len(nums)-2):
            if i>0 and nums[i]==nums[i-1]:
                continue
            left=i+1
            right=len(nums)-1
            #print(str(i)+" "+str(left) + " "+str(right))
            
            target=-nums[i]

            while left<right:
                twosum = nums[left]+nums[right]
                if twosum>target:
                    right-=1
                elif twosum<target:
                    left+=1
                else:
                    #print("Appending: "+str(nums[i])+" "+str(nums[left]) + " "+str(nums[right]))
                    res.append([nums[i],nums[left],nums[right]])

                    while left<right and nums[left]==nums[left+1]:
                        left+=1
                    while left<right and nums[right-1]==nums[right]:
                        right-=1
                    
                    left+=1
                    right-=1
                    
        return res
            
