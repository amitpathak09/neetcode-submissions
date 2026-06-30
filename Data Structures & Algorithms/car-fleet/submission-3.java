class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayDeque<Double> stack = new ArrayDeque<>();

        int[][] cars = new int[position.length][2];
        for(int i=0; i<position.length; i++) {
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        Arrays.sort(cars, (a,b)->Integer.compare(a[0],b[0]));
        for(int i=0; i<position.length; i++) {
            double time = (double)(target-cars[i][0])/cars[i][1];
            stack.push(time);
        }
        int fleets = 1;
        double t = stack.pop();
        while(!stack.isEmpty()) {
            double time=stack.pop();
            if(t>=time) {
                continue;
            } else {
                fleets+=1;
                t=time;
            }
        }
        return fleets;
    }
}
