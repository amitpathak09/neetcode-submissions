class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        ArrayDeque<Integer> monostack = new ArrayDeque<>();
        for(int i=0; i<heights.length; i++) {
            if(!monostack.isEmpty()) {
                if(heights[monostack.peek()]<heights[i]) {
                    monostack.push(i);
                } else {
                    while(!monostack.isEmpty() && heights[monostack.peek()]>=heights[i]) {
                        int t = monostack.pop();
                        int prev = monostack.isEmpty()?-1:monostack.peek();
                        // System.out.println(String.valueOf(i)+" "+String.valueOf(t)+" "+String.valueOf(prev));
                        // System.out.println((i-1-prev)*heights[t]);
                        maxArea = Math.max(maxArea, (i-1-prev)*heights[t]);
                    }
                    monostack.push(i);
                }
            } else {
                monostack.push(i);
            }
        }
        while(!monostack.isEmpty()) {
            int t = monostack.pop();
            int prev = monostack.isEmpty()?-1:monostack.peek();
            maxArea = Math.max(maxArea, (heights.length-1-prev)*heights[t]);
        }
        return maxArea;
        
    }
}
