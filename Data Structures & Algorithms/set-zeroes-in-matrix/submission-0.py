class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        rows_to_zero = set()
        cols_to_zero = set()
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        # Pass 1: Find the zeros
        for r in range(rows):
            for c in range(cols):
                if matrix[r][c] == 0:
                    rows_to_zero.add(r)
                    cols_to_zero.add(c)
        
        # Pass 2: Clear the rows
        for r in rows_to_zero:
            matrix[r] = [0] * cols
            
        # Pass 3: Clear the columns
        for c in cols_to_zero:
            for r in range(rows):
                matrix[r][c] = 0