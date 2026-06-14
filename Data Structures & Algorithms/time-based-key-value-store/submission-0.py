class TimeMap:

    def __init__(self):
        self.timestamps = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        innerMap = self.timestamps.get(key, {})
        innerMap[timestamp]=value
        self.timestamps[key] = innerMap

    def get(self, key: str, timestamp: int) -> str:
        if key in self.timestamps:
            innerMap=self.timestamps[key]
            for i in range(timestamp,0,-1):
                if i in innerMap:
                    return innerMap[i]
            return ""
        else:
            return ""