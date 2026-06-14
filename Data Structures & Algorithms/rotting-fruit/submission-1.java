class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j]==2) {
                    int[] arr = {i,j};
                    queue.offer(arr);
                }
            }
        }
        int maxTime = 0;
        int time =0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(!queue.isEmpty()) {
            int qs = queue.size();
            for(int j=0; j<qs; j++) {
                int[] arr = queue.poll();
                int r = arr[0];
                int c = arr[1];
                for(int[] kv: directions) {
                    int newr = r+kv[0];
                    int newc = c+kv[1];
                    if(newr<0 || newr>rows-1 || newc<0 || newc>cols-1|| grid[newr][newc]!=1) {
                        continue;
                    }
                    grid[newr][newc] = 2;
                    int[] temparr = {newr, newc};
                    queue.offer(temparr);
                }
            }
            System.out.println(queue.size());
            time++;
        }

        for(int x=0; x<rows; x++) {
            for(int y=0; y<cols; y++) {
                if(grid[x][y]==1) {
                    return -1;
                }
            }
        }

        return time==0?time:time-1;
    }
}
