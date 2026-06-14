class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(grid[i][j]=='1') {
                    int node = columns*i + (j+1);
                    List<Integer> list = new ArrayList<>();
                    if(i>0 && grid[i-1][j]=='1') {
                        list.add(columns*(i-1) + j+1);
                    }
                    if(i<rows-1 && grid[i+1][j]=='1') {
                        list.add(columns*(i+1) + j+1);
                    }
                    if(j>0 && grid[i][j-1]=='1') {
                        list.add(columns*(i) + j);
                    }
                    if(j<columns-1 && grid[i][j+1]=='1') {
                        list.add(columns*i + j+2);
                    }
                    map.put(node, list);
                }
            }
        }
        System.out.println(map);
        Deque<Integer> queue = new ArrayDeque<>();
        // List<Integer> visited = ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        int counter = 0;

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            Integer key = entry.getKey();

            if(!visited.contains(key)) {
                counter++;

                queue.offer(key);
            
                while(!queue.isEmpty()) {
                    Integer curr = queue.poll();
                    visited.add(curr);
                    for(Integer k:map.get(curr)) {
                        if(!visited.contains(k)) {
                            queue.offer(k);
                        }
                    }
                }
            }
        }
        return counter;
        
    }
}
