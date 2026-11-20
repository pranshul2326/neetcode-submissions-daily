class Solution {
    int sum = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxArea = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int area = AreaOfIsland(grid, visited, i,j, sum);
                    maxArea = Math.max(area, maxArea);
                }

            }
        }
        return maxArea;
        
    }
    int AreaOfIsland(int[][] grid, boolean[][] visited, int i, int j, int sum){

        if(i<0||j<0||i>=grid.length|| j>=grid[0].length|| visited[i][j]|| grid[i][j]==0){
            return 0;
        }

        sum++;
        visited[i][j]= true;
        
        int newsum = AreaOfIsland(grid,visited, i+1,j,0) + AreaOfIsland(grid,visited, i-1,j,0) + AreaOfIsland(grid,visited, i,j-1,0) + AreaOfIsland(grid,visited, i,j+1,0);
        return newsum + sum;


    }

}
