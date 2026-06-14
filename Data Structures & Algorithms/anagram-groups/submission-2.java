class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            String frequencyString = getFrequencyString(str);
            List<String> list = map.getOrDefault(frequencyString, new ArrayList<>());
            list.add(str);
            map.put(frequencyString, list);
        }
        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
        
    }

    String getFrequencyString(String str) {
        int[] freq = new int[26];
        for(int i=0; i<str.length(); i++) {
            freq[str.charAt(i)-'a']++;
        }
        System.out.println(Arrays.toString(freq));
        return Arrays.toString(freq);
    }
}
