class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue = deque()
        fruitCount = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    queue.append((i,j))
                elif grid[i][j]==1:
                    fruitCount+=1
        time=0
        directions = [(-1,0),(1,0),(0,-1),(0,1)]
        while len(queue)>0 and fruitCount>0:
            size = len(queue)
            for k in range(size):
                rf = queue.popleft()
                for dir in directions:
                    x=rf[0]+dir[0]
                    y=rf[1]+dir[1]
                    if x>=0 and y>=0 and x<len(grid) and y<len(grid[0]) and grid[x][y]==1:
                        grid[x][y] = 2
                        fruitCount-=1
                        queue.append((x,y))
                        print(fruitCount)
            time+=1
            print("time is:"+str(time))
        if(fruitCount==0):
            return time
        return -1