class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] indices = new int[2];
        int windowSize = 1;
        int i=0;
        for(windowSize=1; windowSize+i<n; windowSize++) {
            for(i=0; i+windowSize<n; i++) {
                if(numbers[i]+numbers[i+windowSize]==target) {
                    indices[0]=i+1;
                    indices[1]=i+1+windowSize;
                }
            }
            i=0;
        }
        
        return indices;
    }
}
