class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs) {
            int len = str.length();
            sb.append(len).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int length = str.length();
        int i = 0;
        while(i<length) {
            int l=0;
            StringBuilder sb = new StringBuilder();
            while(str.charAt(i)!='#') {
                sb.append(str.charAt(i));
                i++;
            }
            l=Integer.parseInt(sb.toString());
            i++;
            StringBuilder sb2 = new StringBuilder();
            int size = i+l;
            while(i<size) {
                sb2.append(str.charAt(i));
                i++;
            }
            strs.add(sb2.toString());
        }
        return strs;
    }
}
