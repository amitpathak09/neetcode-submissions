class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            set.add(n);
            int temp = calcSqrd(n);
            if(temp==1) {
                return true;
            } else {
                n=temp;
            }
        }
        return false;
    }

    private int calcSqrd(int n) {
        int sum=0;
        while(n!=0) {
            sum+=Math.pow(n%10,2);
            n=n/10;
        }
        return sum;
    }
}
