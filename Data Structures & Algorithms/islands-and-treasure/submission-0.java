class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Deque<ArrayList<Integer>> queue = new ArrayDeque<>();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j]==0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    queue.offer(list);
                }
            }
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()) {
            ArrayList<Integer> list = queue.poll();
            int r=list.get(0);
            int c=list.get(1);
            for(int[] dir: directions) {
                int newr = r+dir[0];
                int newc = c+dir[1];
                if(newr>rows-1 || newr<0 || newc>cols-1 || newc<0 || grid[newr][newc]!=Integer.MAX_VALUE) {
                    continue;
                }
                grid[newr][newc] = grid[r][c]+1;
                ArrayList<Integer> nl = new ArrayList<>();
                nl.add(newr);
                nl.add(newc);
                queue.offer(nl);

            }


        }

    }
}
