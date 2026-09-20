class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int boardNum = (i/3)*3 +(j/3)+1;
                String h = board[i][j]+"r"+i;
                String v = board[i][j]+"c"+j;
                String b = board[i][j]+"b"+boardNum;

                if(set.contains(h)||set.contains(v)||set.contains(b)){
                    System.out.println(h+" "+v+" "+" "+b);
                    return false;
                }else{
                    set.add(h);
                    set.add(v);
                    set.add(b);
                }

            }
        }
        return true;
        
    }
}
