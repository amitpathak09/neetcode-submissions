class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i=s.length()-1; i>=0; i--) {
            System.out.println(i);
            for(String word: wordDict) {
                if(word.length()+i<=s.length() && word.equals(s.substring(i,i+word.length()))) {
                    System.out.println(word);
                    dp[i]=dp[i+word.length()];
                }
                if(dp[i]) {
                    System.out.println("DP True for i="+i);
                    break;
                }
            }
        }
        return dp[0];

        
    }
}
