class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*we'll have to devise a frequency counter method, this method will count the frequency
        of characters in s1 and we'll use a sliding with method to count the frequency of substrings in s2
        if anything matches, true, else false
        */

        int l1 = s1.length();
        int l2 = s2.length();
        if(l1>l2) return false;
        int[] f1 = charFrequencyCounter(s1);

        int l=0;
        int r=l1-1;
        int[] f2 = charFrequencyCounter(s2.substring(0,l1));

        while(r+1<l2) {
            if(Arrays.equals(f1,f2)) {
                return true;
            }
            f2[s2.charAt(l)-'a']--;
            f2[s2.charAt(r+1)-'a']++;
            l++;
            r++;
        }
        if(Arrays.equals(f1,f2)) {
                return true;
        } else {
            return false;
        }
    }

    private int[] charFrequencyCounter(String s) {
        int[] frequency = new int[26];
        int l = s.length();

        for(int i=0; i<l; i++) {
            frequency[s.charAt(i)-'a']++;
        }
        return frequency;
    }
}
