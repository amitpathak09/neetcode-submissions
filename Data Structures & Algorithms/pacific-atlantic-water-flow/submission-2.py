class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        res = set()
        rows=len(heights)
        cols=len(heights[0])

        def dfs(i,j):
            visited = set()
            dirs=[(-1,0),(1,0),(0,-1),(0,1)]
            pac = False
            atl = False
            stack = []
            stack.append((i,j))
            while stack:
                if pac and atl:
                    res.add((i,j))
                    return
                curr = stack.pop()
                visited.add(curr)
                r=curr[0]
                c=curr[1]
                for di in dirs:
                    
                    newr = r+di[0]
                    newc = c+di[1]
                    if newc<0 or newr<0:
                        pac = True
                        continue
                    if newr>=rows or newc>=cols:
                        atl = True
                        continue

                    if heights[newr][newc]<=heights[r][c] and (newr,newc) not in visited:
                        if (newr,newc) in res:
                            res.add((i,j))
                            return
                        stack.append((newr,newc))
            if pac and atl:
                    res.add((i,j))
                    return
        for i in range(rows):
            for j in range(cols):
                dfs(i,j)
        return [list(item) for item in res]
                            




