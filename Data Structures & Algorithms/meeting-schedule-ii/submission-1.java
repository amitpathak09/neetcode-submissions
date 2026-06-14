/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0) return 0;
        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        List<Interval> intervalsCopy = new ArrayList<>(intervals);

        intervalsCopy.sort((a,b)->Integer.compare(a.end,b.end));
        int maxEndTime = intervalsCopy.get(intervalsCopy.size()-1).end;
        int[] overlaps = new int[maxEndTime];

        for(Interval interval:intervals) {
            for(int i=interval.start+1; i<=interval.end; i++) {
                overlaps[i-1]++;
            }
        }
        int maxOverlaps = 0;
        for(int overlap:overlaps) {
            maxOverlaps = Math.max(maxOverlaps,overlap);
        }

        return maxOverlaps;

    }
}
