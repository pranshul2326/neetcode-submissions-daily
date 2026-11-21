class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(board[i][j]=='O' && (i!=n-1 || j!=m-1)){
        //             makeNbrZero(board, i, j);
        //         }
        //     }
        // }

        for(int i=0;i<n;i++){
            if(board[i][0] == 'O'){
                fillPinZero(board,i,0);
            }
            if(board[i][m-1] == 'O'){
                fillPinZero(board,i,m-1);
            }
            
        }
        for(int j=0;j<m;j++){
            if(board[0][j] == 'O'){
                fillPinZero(board,0,j);
            }
            if(board[n-1][j] == 'O'){
                fillPinZero(board,n-1,j);
            }
            
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='P'){
                    board[i][j]='O';
                }
            }
        }
        
    }

    int[][] dirn = {{1,0}, {-1,0}, {0,1},{0,-1}};

    void fillPinZero(char[][] board, int r, int c){
        if(r<0||c<0||r>=board.length||c>=board[0].length||board[r][c]=='X'||board[r][c]=='P'){
                return;
        }
        board[r][c] = 'P';
        for(int i=0;i<4;i++){
            int ni = r+dirn[i][0];
            int nj = c+dirn[i][1];
            fillPinZero(board,ni,nj);
        }
    }
    void makeNbrZero(char[][] board, int r, int c){
        
        for(int i=0;i<4;i++){
            int ni = r+dirn[i][0];
            int nj = c+dirn[i][1];

            if(ni<0||nj<0||ni>=board.length||nj>=board[0].length||board[ni][nj]=='X'){
                continue;
            }else if(board[ni][nj]=='O'){
                board[r][c] = 'X';
                makeNbrZero(board, ni, nj);
            }
        }
    }
}
