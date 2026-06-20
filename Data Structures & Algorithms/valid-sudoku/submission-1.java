class Solution {
    public boolean isValidSudoku(char[][] board) {

        //check rows
        for(int i=0; i<9; i++) {
            Set<Integer> hashset = new HashSet<>();
            for(int j=0; j<9; j++) {
                if(board[i][j]!='.') {
                    if(!hashset.add(board[i][j]-'0')) {
                        return false;
                    }
                }
            }
        }

        //check cols
        for(int i=0; i<9; i++) {
            Set<Integer> hashset = new HashSet<>();
            for(int j=0; j<9; j++) {
                if(board[j][i]!='.') {
                    if(!hashset.add(board[j][i]-'0')) {
                        return false;
                    }
                }
            }
        }

        //check boxes of edge size 3
        for(int i=0; i<9; i=i+3) {
            for(int j=0; j<9; j=j+3) {
                Set<Integer> hashset = new HashSet<>();
                for(int k=0; k<3; k++) {
                    for(int l=0; l<3; l++) {
                        if(board[i+k][j+l]!='.' && !hashset.add(board[i+k][j+l]-'0')) {
                            // System.out.println(i);
                            // System.out.println(j);
                            // System.out.println(k);
                            // System.out.println(l);
                            return false;
                        }
                    }
                }
            }
        }

        return true;
        
    }
}
