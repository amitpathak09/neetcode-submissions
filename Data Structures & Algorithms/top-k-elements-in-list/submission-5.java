class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(int num: nums) {
            int frequency = frequencyMap.getOrDefault(num, 0);
            frequencyMap.put(num, frequency+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(frequencyMap.get(a)-frequencyMap.get(b)));
        pq.addAll(frequencyMap.keySet());
        while(pq.size()>k) {
            pq.poll();
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = pq.poll();
        }

        return res;
        
    }
}
