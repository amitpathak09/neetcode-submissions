class Solution {
    public List<String> generateParenthesis(int n) {
        int lp = n;
        int rp = n;
        if(n==0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), res);
        return res;
        
    }

    void backtrack(int lpc, int rpc, int n, StringBuilder sb, List<String> res) {
        if(lpc==n && rpc==n) {
            res.add(sb.toString());
            return;
        }
        
        if(lpc<n) {
            sb.append('(');
            lpc++;
            backtrack(lpc,rpc,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
            lpc--;
        }

        if(rpc<lpc) {
            sb.append(')');
            rpc++;
            backtrack(lpc,rpc,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
            rpc--;
        }
    
    }
}
