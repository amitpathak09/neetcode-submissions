class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> hashmap1 = new HashMap<>();
        HashMap<Character,Integer> hashmap2 = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            Character a = (Character)s.charAt(i);
            Character b =(Character)t.charAt(i);
            if(hashmap1.containsKey(a)) {
                hashmap1.replace(a, hashmap1.get(a) +1);
            } else {
                hashmap1.put(a,1);
            }

            if(hashmap2.containsKey(b)) {
                hashmap2.replace(b, hashmap2.get(b) +1);
            } else {
                hashmap2.put(b,1);
            }
        }
        if(hashmap1.equals(hashmap2)) return true;
        return false;
    }
}
