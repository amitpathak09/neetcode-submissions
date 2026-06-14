class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        int[] f = new int[length+1];
        f[length]=1;
        for(int i=length-1; i>=0; i--) {
            if(s.charAt(i)=='0') {
                f[i]=0;
            } else {
                if(i+1<=length-1 && (s.charAt(i)=='1'|| (s.charAt(i)=='2'&&s.charAt(i+1)-'0'<7))) {
                    f[i]=f[i+1]+f[i+2];
                } else {
                    f[i]=f[i+1];
                }
            }
        }
        return f[0];
    }
}
