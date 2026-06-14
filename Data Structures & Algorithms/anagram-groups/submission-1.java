class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] chars = new int[26];
            for(int i=0; i<str.length(); i++) {
                chars[str.charAt(i)-'a']++;
            }

            String key = Arrays.toString(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
