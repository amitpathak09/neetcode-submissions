class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        //assuming i is at the center of the palindrome
        int lpl = 0;
        String lps = null;
        for(int i=0; i<length; i++) {
            int l=i, r=i;
            int pl = 0;
            while(l>=0 && r<length && s.charAt(l)==s.charAt(r)) {
                pl=(r-l+1);
                if(pl>lpl) {
                    lpl = pl;
                    lps = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }

        for(int j=0; j<length; j++) {
            int l=j, r=j+1;
            int pl = 0;
            while(l>=0 && r<length && s.charAt(l)==s.charAt(r)) {
                pl = (r-l+1);
                if(pl>lpl) {
                    lpl = pl;
                    lps = s.substring(l,r+1);
                }
                l--;
                r++;
            }

        }
        System.out.println(lpl);
        return lps;
    }
}
