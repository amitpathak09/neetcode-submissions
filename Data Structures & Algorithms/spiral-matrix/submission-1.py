class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res=[]
        m,n=len(matrix),len(matrix[0])
        top, bottom, left, right = 0, m-1, 0, n-1

        while top<=bottom and left<=right:
            for a in range(left, right+1):
                res.append(matrix[top][a])
            top+=1

            for b in range(top, bottom+1):
                res.append(matrix[b][right])
            right-=1

            if top>bottom or left>right:
                break

            for c in range(right, left-1, -1):
                res.append(matrix[bottom][c])
            bottom-=1

            for d in range(bottom, top-1, -1):
                res.append(matrix[d][left])
            left+=1

        return res