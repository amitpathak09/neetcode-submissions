class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int longestSubstring = 0;
        int n = s.length();
        int l=0;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            while(set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
                // System.out.println(c);
            } 
            System.out.println(c);
            set.add(c);
            longestSubstring = Math.max(longestSubstring, set.size());
        }
        return longestSubstring;
    }
}
