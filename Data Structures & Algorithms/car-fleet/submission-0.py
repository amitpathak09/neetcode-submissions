class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:

        n=len(position)
        cars = []
        for i in range(n):
            cars.append((position[i],speed[i]))
        cars.sort()

        totalFleets = 1
        car = cars.pop()
        s = car[1]
        p = car[0]
        t = (target-p)/s

        while len(cars)!=0:
            car = cars.pop()
            s = car[1]
            p = car[0]
            t2 = (target-p)/s

            if t2<=t:
                continue
            else:
                t=t2
                totalFleets+=1
                

        return totalFleets    
        