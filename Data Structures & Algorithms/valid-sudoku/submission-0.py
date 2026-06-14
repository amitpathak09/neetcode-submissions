class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            if not self.checkSudoku(board, [i], range(9)):
                return False
        for j in range(9):
            if not self.checkSudoku(board, range(9), [j]):
                return False
        
        for k in range(0, 9, 3):
            for l in range(0, 9, 3):
                if not self.checkSudoku(board, range(k,k+3), range(l,l+3)):
                    return False

        return True



    
    def checkSudoku(self, board: List[List[str]], iRange: List[int], jRange: List[int])->bool:
        hashset = set()
        for i in iRange:
            for j in jRange:
                if board[i][j]==".":
                    continue
                if int(board[i][j]) not in range(1,10):
                    return False
                if int(board[i][j]) in hashset:
                    return False
                else:
                    hashset.add(int(board[i][j]))
        return True