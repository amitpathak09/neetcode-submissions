class TimeMap:

    def __init__(self):
        self.timestamps = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key in self.timestamps:
            innerList = self.timestamps.get(key)
            innerList.append((timestamp,value))
        else:
            innerList = [(timestamp,value)]
            self.timestamps[key]=innerList

    def get(self, key: str, timestamp: int) -> str:
        if key in self.timestamps:
            innerList=self.timestamps[key]
            l,r=0,len(innerList)-1
            res=""
            while l<=r:
                mid = (l+r)//2
                if innerList[mid][0]<=timestamp:
                    res=innerList[mid][1]
                    l=mid+1
                    
                elif innerList[mid][0]>timestamp:
                    r=mid-1
            return res
        else:
            return ""