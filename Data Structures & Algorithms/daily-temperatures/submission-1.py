class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:

        res=[0]*len(temperatures)
        for i in range(len(temperatures)-2,-1,-1):
            if temperatures[i+1]>temperatures[i]:
                res[i]=1
            else:
                if res[i+1]==0:
                    res[i]=0
                else:
                    j=i+1
                    while res[j]!=0 and temperatures[j]<=temperatures[i]:
                        j+=res[j]
                    if temperatures[j]>temperatures[i]:
                        res[i]=j-i
        return res