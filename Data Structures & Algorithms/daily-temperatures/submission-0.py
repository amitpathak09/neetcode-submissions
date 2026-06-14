class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        stack.append(0)

        res = [0]*len(temperatures)
        for i in range(1,len(temperatures)):
            if stack and temperatures[i]<temperatures[stack[-1]]:
                stack.append(i)
            
            else:
                while stack and temperatures[i]>temperatures[stack[-1]]:
                    index = stack.pop()
                    res[index]=i-index
                stack.append(i)
        return res