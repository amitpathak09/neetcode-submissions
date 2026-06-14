class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int v = verticalBinSearch(matrix, target, 0, m-1);
        return binSearch(matrix[v], target, 0, n-1);
        
    }

    private int verticalBinSearch(int[][] matrix, int target, int start, int end) {
        if(end-start==0) return start;
        int mid=(start+end)/2;
        if(matrix[mid+1][0]<=target) {
            return verticalBinSearch(matrix, target, mid+1, end);
        } else {
            return verticalBinSearch(matrix, target, start, mid);
        }
    }

    private boolean binSearch(int[] row, int target, int start, int end) {
        if(start==end) {
            return row[start]==target;
        }
        int mid=(end+start)/2;
        if(row[mid]==target) return true;
        else if(row[mid]<target) {
            return binSearch(row, target, mid+1, end);
        } else {
            return binSearch(row, target, start, mid);
        }
    }
}
