class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l=0
        r=len(heights)-1
        trappedWater = 0
        maxTrappedWater = 0

        while l<r:
            trappedWater = (r-l) * min(heights[l], heights[r])
            #print(trappedWater, l, r)
            if trappedWater > maxTrappedWater:
                maxTrappedWater = trappedWater

            if heights[l]>heights[r]:
                r-=1
            else:
                l+=1

        return maxTrappedWater    


        