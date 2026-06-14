class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n=len(heights)
        stack=[]
        maxArea=0
        for i in range(n+1):
            print(stack, maxArea)
            idx=i
            while stack and (i==n or heights[i]<stack[-1][1]):
                curr=stack.pop()
                idx=curr[0]
                h=curr[1]
                area=(i-idx)*h
                if area>maxArea:
                    maxArea=area
            
            if i<n:
                stack.append((idx,heights[i]))
        return maxArea