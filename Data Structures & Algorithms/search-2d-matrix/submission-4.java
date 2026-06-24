class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int rows = matrix.length;

        if(matrix[0][0]>target || matrix[rows-1][cols-1]<target) {
            return false;
        }

        int top = 0;
        int bottom = rows-1;
        int start = 0;
        while(bottom>=top) {
            int mid = (top+bottom)/2;
            if(matrix[mid][0]==target) {
                return true;
            } else if(matrix[mid][0]>target) {
                if(mid>0 && matrix[mid-1][0]<target) {
                    start = mid-1;
                    break;
                } else {
                    bottom = mid;
                }
                
            } else if(matrix[mid][0]<target) {
                if(mid<bottom && matrix[mid+1][0]>target) {
                    start = mid;
                    break;
                } else if(matrix[mid][cols-1]>=target) {
                    start=mid;
                    break;
                } else {
                    top = mid+1;
                }
                
            }
        }

        
        int l=0, r=cols-1;
        while(l<=r) {
            int mid=(l+r)/2;
            if(matrix[start][mid]==target) {
                return true;
            } else if(matrix[start][mid]>target) {
                if(mid>0 && matrix[start][mid-1]<target) {
                    return false;
                } else {
                    r=mid;
                }
            } else if(matrix[start][mid]<target) {
                if(mid<cols-1 && matrix[start][mid+1]>target) {
                    return false;
                } else {
                    l=mid+1;
                }
            }
        }
    
        return false;
        
    }
}
