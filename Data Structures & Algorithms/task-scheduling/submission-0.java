class Solution {
    public int leastInterval(char[] tasks, int n) {

        int size = tasks.length;
        int[] frequency = new int[26];
        for(char task: tasks) {
            frequency[task-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int f: frequency) {
            if(f>0) {
                pq.offer(f);
            }
        }

        int time = 0;
        
        while(!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int taskCount = 0;
            int cycle = n+1;
            while(cycle>0 && !pq.isEmpty()) {
                temp.add(pq.poll());
                cycle--;
                taskCount++;
            }

            for(int count:temp) {
                if(count-1>0) {
                    pq.offer(count-1);
                }
            }

            time+=pq.isEmpty()? taskCount:n+1;
        }

        return time;
        
    }
}
