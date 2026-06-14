class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int columns=grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int maxArea = 0;
        int area = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(grid[i][j]==1 && !visited[i][j]) {
                    area = numOfElements(grid, visited, i, j);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;

    }

    int numOfElements(int[][] grid, boolean[][] visited, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        int area=0;
        if(i>rows-1 || i<0 || j>cols-1 || j<0 || grid[i][j]==0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1+numOfElements(grid, visited, i-1, j) +
        numOfElements(grid, visited, i+1, j) +
        numOfElements(grid, visited, i, j-1) +
        numOfElements(grid, visited, i, j+1);
    }

}
