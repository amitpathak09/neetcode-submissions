class Solution {
    public String minWindow(String s, String t) {

        //"ZDSABBBBBBCCCP" and "ABBC"-> answer will be "ABBBBBC"
        //countOfCharacters
        int sizeS = s.length();
        int sizeT = t.length();

        if(sizeT>sizeS) {
            return "";
        }

        int l=0;
        int r=sizeT-1;

        Map<Character,Integer> ft = frequencyCounter(t);
        Map<Character, Integer> fs = frequencyCounter(s.substring(l,r+1));
        //System.out.println("Comparison output is:"+ fs.equals(ft));
        String res="";
        while(r<sizeS && l<=r) {
            if(compareMaps(ft, fs)) {
                if(s.substring(l,r+1).length()<res.length() || res.equals("")) {
                    res=s.substring(l,r+1);
                    System.out.println(res);
                }
                if(l<=r) {
                    fs.put(s.charAt(l), fs.get(s.charAt(l))-1);
                }
                l++;
            } else {
                r++;
                if(r<sizeS) {
                    fs.put(s.charAt(r),fs.getOrDefault(s.charAt(r),0)+1);
                }
            }
        }
        return res;
        
    }

    private Map<Character, Integer> frequencyCounter(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        int l = s.length();
        for(int i=0; i<l; i++) {
            frequency.put(s.charAt(i),frequency.getOrDefault(s.charAt(i),0)+1);
        }
        return frequency;
    }

    private boolean compareMaps(Map<Character, Integer> absMap, Map<Character, Integer> partialMap) {
        for(Map.Entry<Character, Integer> entry: absMap.entrySet()) {
            if(partialMap.getOrDefault(entry.getKey(),0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
