class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            String len = Integer.toString(str.length());
            sb.append(len.length());
            sb.append(len);
            sb.append(str);
        }
        return new String(sb);

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if(str.length()==0){
            return res;
        }
        //13abc212abcdefghijklmno
        while(str.length()!=0) {
            int l = (str.charAt(0))-'0';
            int size = Integer.parseInt(str.substring(1,1+l));
            res.add(str.substring(1+l,1+l+size));
            str = str.substring(1+l+size, str.length());
        }
        return res;
    }
}
