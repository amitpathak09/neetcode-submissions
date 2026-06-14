class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:

        heap = []

        for i in points:
            x,y=i[0],i[1]
            distance = math.sqrt(pow(x,2)+pow(y,2))
            heapq.heappush(heap, (distance, x, y))
        res = []
        for c in range(k):
            distance, x, y = heapq.heappop(heap)
            res.append([x,y])
        
        return res