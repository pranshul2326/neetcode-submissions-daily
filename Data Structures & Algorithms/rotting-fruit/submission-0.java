class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                 else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int[][] dirn = {{1,0},{-1,0},{0,-1},{0,1}};
        while(q.size()>0 && fresh > 0){

             int size = q.size();
             for (int k = 0; k < size; k++) {
            int[] rotten_orange = q.poll();
            int h = rotten_orange[0];
            int v = rotten_orange[1];

            for(int i=0;i<dirn.length;i++){
                int x =h + dirn[i][0];
                int y =v + dirn[i][1];

                if(x<0||y<0||x>=n||y>=m||grid[x][y]!=1){
                    continue;
                }
                q.offer(new int[]{x,y});
                 
                 grid[x][y] = 2;
                 fresh--;

                
            }
             }
             time++;
           

            

        }
        return  fresh == 0 ? time : -1;
    
}
}