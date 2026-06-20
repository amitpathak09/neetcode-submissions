class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int stone: stones) {
            pq.add(stone);
        }
        while(pq.size()>1) {
            int a = pq.poll();
            int b = pq.poll();
            if(Math.abs(a-b)>0) {
                pq.add(Math.abs(a-b));
            }
        }
        return pq.size()==0?0:pq.poll();
        
    }
}
