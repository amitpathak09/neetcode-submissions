class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        if len(stones)==1:
            return stones[0]
        if len(stones)==2:
            return abs(stones[1]-stones[0])

        stones = [-s for s in stones]
        heapq.heapify(stones)
        while len(stones)>1:
            firstStone = -1* heapq.heappop(stones)
            #print("secondStone: "+ str(secondStone))
            secondStone = -1* heapq.heappop(stones)
            #print("-------firstStone: "+ str(firstStone))
            if firstStone!=secondStone:
                heapq.heappush(stones, -1* (firstStone-secondStone))


        if len(stones)==1:
            return -1*stones[0]
        else:
            return 0