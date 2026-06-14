class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        size = len(piles)
        if h<size:
            return -1

        ls = 1
        us = max(piles)

        def timeTaken(speed):
            tt = 0
            for i in range(len(piles)):
                tt+=math.ceil(piles[i]/speed)
            return tt

        while ls<us:
            currSpeed = (ls+us)//2
            t = timeTaken(currSpeed)
            print(ls, us)
            if t<=h:
                us=currSpeed
            else:
                ls=currSpeed+1

        return ls

        
