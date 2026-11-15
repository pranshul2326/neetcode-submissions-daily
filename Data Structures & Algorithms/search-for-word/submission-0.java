class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 if(searchWord(board, word, i, j, 0)) return true;
            }
        }
        return false;
        
    }

    public boolean searchWord(char[][] board, String word, int r, int c, int idx){

        if(idx==word.length()){
            return true;
        }

        if(r<0 || c<0|| r>=board.length || c>=board[0].length || board[r][c]!=word.charAt(idx)){
            return false;
        }



        char temp = board[r][c];
        board[r][c] = '#';
        if(searchWord(board,word, r+1, c, idx+1) || searchWord(board,word, r-1, c, idx+1) || searchWord(board,word, r, c+1, idx+1)|| searchWord(board,word, r, c-1, idx+1))
        return true;

        board[r][c] = temp;
        
        return false;
        
    }
}
