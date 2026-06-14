class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer,List<int[]>> edges = new HashMap<>();
        for(int[] node: times) {
            int source = node[0];
            int destination = node[1];
            int time = node[2];
            List<int[]> neighbours = edges.getOrDefault(source, new ArrayList<>());
            neighbours.add(new int[]{destination, time});
            edges.put(source, neighbours);

        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int[] timeToReach = new int[n];
        Arrays.fill(timeToReach, Integer.MAX_VALUE);
        Set<Integer> visited = new HashSet<>();

        pq.add(new int[]{0,k});
        // System.out.println(edges);

        while(pq.size()!=0) {
            int[] element = pq.poll();
            int source = element[1];
            int time = element[0];
            if (visited.contains(source)) {
                continue;
            } else {
                visited.add(source);
            }
            if (timeToReach[source-1]>time) {
                timeToReach[source-1]=time;
            }
            if(!edges.containsKey(source)) {
                continue;
            }
            for(int[] neighbour:edges.get(source)) {
                int tt=neighbour[1];
                int ne=neighbour[0];

                pq.add(new int[]{tt+time, ne});
            }
        }
        int maxTime=0;
        for(int t:timeToReach) {
            if(t==Integer.MAX_VALUE) {
                return -1;
            } else if(t>maxTime) {
                maxTime = t;
            }
        }

        return maxTime;

    }
}
