class Solution {
    public int minCostConnectPoints(int[][] points) {
        int m=points.length;

        Map<Integer,List<int[]>> edges = new HashMap<>();

        for(int i=0; i<m; i++) {
            List<int[]> neighbours = new ArrayList<>();
            for(int j=0; j<m; j++){
                if(i==j) {
                    continue;
                }
                int distance=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                int[] neighbour = new int[]{j, distance};
                neighbours.add(neighbour);
            }
            edges.put(i,neighbours);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        Set<Integer> visited = new HashSet<>();

        pq.add(new int[]{0,0});
        int totalLength=0;

        while(pq.size()!=0) {
            int[] element = pq.poll();
            int dist=element[0];
            int dest=element[1];

            if(visited.contains(dest)) {
                continue;
            } else {
                visited.add(dest);
            }
            totalLength+=dist;
            if(visited.size()==m) {
                break;
            }
            for(int[] neighbour: edges.get(dest)) {
                int ds = Math.abs(points[dest][0]- points[neighbour[0]][0])+Math.abs(points[dest][1]-points[neighbour[0]][1]);
                pq.add(new int[]{ds,neighbour[0]});
            }
        }
        return totalLength; 
    }
}
