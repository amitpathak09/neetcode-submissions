class Solution:
    def trap(self, height: List[int]) -> int:
        n=len(height)
        if n<3: 
            return 0

        leftBoundary = [0]*n
        maxLeft=0
        rightBoundary = [0]*n
        maxRight=0
        for i in range(1,n):
            if height[i-1]>maxLeft:
                maxLeft = height[i-1]
                leftBoundary[i]=maxLeft
            else:
                leftBoundary[i]=maxLeft

        for j in range(n-2, -1, -1):
            if height[j+1]>maxRight:
                maxRight = height[j+1]
                rightBoundary[j]=maxRight
            else:
                rightBoundary[j]=maxRight
        
        waterStored=0
        for k in range(1,n-1):
            if height[k]<leftBoundary[k] and height[k]<rightBoundary[k]:
                waterStored+=(min(rightBoundary[k],leftBoundary[k])-height[k])


        return waterStored