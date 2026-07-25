class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        for(int[] point: points) {
            pq.add(new double[]{dist(point), (double)point[0], (double)point[1]});
        }

        while(pq.size()!=k) {
            pq.poll();
        }

        int[][] res = new int[k][2];
        int i=0;
        while(!pq.isEmpty()) {
            double[] element = pq.poll();
            res[i][0] = (int)element[1];
            res[i][1] = (int)element[2];
            i++;
        }
        return res;

    }

    private double dist(int[] point) {
        return Math.pow(Math.pow(point[1],2)+Math.pow(point[0],2),0.5);
    }
}
