class Solution {
    public int[][] merge(int[][] intervals) {
        int size = intervals.length;

        List<int[]> res = new ArrayList<>();

        //sorting the 2d array by start time

        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        int startTime=intervals[0][0];
        int endTime=intervals[0][1];
        for(int i=1; i<size; i++) {

            if(endTime>=intervals[i][0]) {
                endTime=Math.max(endTime,intervals[i][1]);
            } else {
                int[] interval = new int[2];
                interval[0]=startTime;
                interval[1]=endTime;
                res.add(interval);

                startTime=intervals[i][0];
                endTime=intervals[i][1];
            }
        }

        int[] interval = new int[2];
        interval[0]=startTime;
        interval[1]=endTime;
        res.add(interval);




        return res.toArray(new int[res.size()][]);
    }
}
