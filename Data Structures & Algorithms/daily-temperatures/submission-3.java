class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        int idx = temperatures.length-1;
        for(int i=0; i<temperatures.length; i++) {
            if(stack.isEmpty()) {
                //System.out.println(stack);
                res[idx-i]=0;
                stack.push(new int[]{temperatures[idx-i], idx-i});
            } else {
                while(!stack.isEmpty()) {
                    if(stack.peek()[0]>temperatures[idx-i]) {
                        // System.out.print(idx-i+":");
                        // System.out.println(Arrays.toString(stack.peek()));
                        res[idx-i]=stack.peek()[1]-(idx-i);
                        stack.push(new int[]{temperatures[idx-i],(idx-i)});
                        break;
                    } else {
                        stack.pop();
                    }
                }

                if(stack.isEmpty()) {
                    //System.out.println(stack);
                    res[idx-i]=0;
                    stack.push(new int[]{temperatures[idx-i], idx-i});
                }
            }
        }
        return res;

    }
}
