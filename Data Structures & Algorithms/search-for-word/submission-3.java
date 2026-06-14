class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m=board.length;
        int n=board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]==word.charAt(0)) {
                    StringBuilder sb = new StringBuilder();
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j]=true;
                    sb.append(word.charAt(0));
                    if(backtrack(board, word, i, j, sb, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, String word, int m, int n, StringBuilder sb, boolean[][] visited) {
        if(sb.toString().equals(word)) {
            return true;
        }
        if(sb.length()==word.length()) {
            return false;
        }
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        for(int[] dir: dirs) {
            int dm = m+dir[0];
            int dn = n+dir[1];

            if(dm>=0 && dm<board.length && dn>=0 && dn<board[0].length &&
             !visited[dm][dn] && word.charAt(sb.length())==board[dm][dn]) {
                sb.append(board[dm][dn]);
                visited[dm][dn]=true;
                if(backtrack(board, word, dm, dn, sb, visited)) {
                    return true;
                }

                visited[dm][dn]=false;
                sb.deleteCharAt(sb.length()-1);
            }
        }

        return false;
    }
}
