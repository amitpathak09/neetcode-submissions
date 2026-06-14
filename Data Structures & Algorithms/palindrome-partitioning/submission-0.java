class Solution {
    List<List<String>> res = new ArrayList<>();
    boolean[][] psbs;

    public List<List<String>> partition(String s) {
        psbs = new boolean[s.length()][s.length()];
        getPdArray(s);

        backtrack(s, 0, new ArrayList<>());
        return res;
        
    }

    public void backtrack(String s, int start, ArrayList<String> list) {
        if(start==s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<s.length(); i++) {
            if(psbs[start][i]) {
                list.add(s.substring(start, i+1));

                backtrack(s, i+1, list);

                list.remove(list.size()-1);
            }
        }
    }


    private void getPdArray(String s) {
        for(int i=0; i<s.length(); i++) {
            int l=i;
            int r=i;
            expand(l,r,s);
        }

        for(int j=0; j+1<s.length(); j++) {
            int l=j;
            int r=j+1;
            expand(l,r,s);
        }
    }

    private void expand(int l, int r, String s) {
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
            psbs[l][r] = true;
            l--;
            r++;
        }
    }
}
