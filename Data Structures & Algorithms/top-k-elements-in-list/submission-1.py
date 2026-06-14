class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        map = {}
        for i in nums:
            map[i]=1+map.get(i,0)
        
        heap=[]
        heapq.heapify(heap)
        for key,value in map.items():
            heapq.heappush(heap, (value, key))

        while len(heap)>k:
            heapq.heappop(heap)

        res=[]
        while len(heap)!=0:
            res.append(heapq.heappop(heap)[1])
        
        return res