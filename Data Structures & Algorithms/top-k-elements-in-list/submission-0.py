class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = {}

        for i in nums:
            map[i]=1+map.get(i,0)
        
        arr=[]
        for num,count in map.items():
            arr.append([count, num])
        arr.sort()
        res=[]
        while len(res)<k:
            res.append(arr.pop()[1])

        return res