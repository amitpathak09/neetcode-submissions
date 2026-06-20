class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        if(s.length()==0) return 0;
        int l=0, r=0;
        int maxL=1;
        map.put(s.charAt(0),0);

        while(l<=r && r<s.length()-1) {
            r++;
            if(!map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), r);
                if(r-l+1>maxL) {
                    maxL = r-l+1;
                }
            } else {
                int pos = map.get(s.charAt(r));
                while(l<=pos) {
                    map.remove(s.charAt(l));
                    l++;
                }
                map.put(s.charAt(r),r);
            }

        }
        return maxL;
        
    }
}
