class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows=len(board)
        cols=len(board[0])
        visited = set()

        #queue=deque(), append, popleft
        dirs=[(-1,0),(1,0),(0,-1),(0,1)]
        queue = deque()
        for i in range(rows):
            for j in range(cols):
                if (i==0 or i==rows-1 or j==0 or j==cols-1) and board[i][j]=="O":
                    queue.append((i,j))
                while  queue:
                    r,c = queue.popleft()
                    if board[r][c]=="O":
                        board[r][c]="T"
                        for dr,dc in dirs:
                            newr,newc = r+dr,c+dc
                            if newr>=0 and newr<rows and newc>=0 and newc<cols and board[newr][newc]=="O":
                                queue.append((newr,newc))

                        
        for a in range(rows):
            for b in range(cols):
                if board[a][b]=="O":
                    board[a][b]="X"
                elif board[a][b]=="T":
                    board[a][b]="O"

                    


        