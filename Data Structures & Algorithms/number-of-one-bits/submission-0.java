class Solution {
    public int hammingWeight(int n) {
        int setCount = 0;
        for(int i=0;i<32;i++) {
            if((1<<i & n) != 0) {
                setCount++;
            }
        }
        return setCount;
    }
}
