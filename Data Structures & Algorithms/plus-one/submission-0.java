class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length+1];
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--) {
            int temp = digits[i]+carry;
            carry=temp/10;
            res[i+1] = temp%10;
        }
        res[0]=carry;
        if(res[0]==0) {
            return Arrays.copyOfRange(res, 1, digits.length+1);
        } else {
            return res;
        }
    }
}
