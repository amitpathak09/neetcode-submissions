class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int size = strs.length;
        String[] flattenedStr = new String[size];
        for(int i=0; i<size; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            flattenedStr[i] = new String(chars);
        }
        List<List<String>> lists = new ArrayList<>();
        boolean[] seen = new boolean[size];
        for(int j=0; j<size; j++) {
            List<String> list = new ArrayList<>();
            if(seen[j]) continue;
            list.add(strs[j]);
            
            for(int k=j+1; k<size; k++) {
                System.out.println(flattenedStr[j].toString()+" "+flattenedStr[k].toString());
                if(flattenedStr[j].equals(flattenedStr[k])) {
                    seen[k] = true;
                    list.add(strs[k]);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
