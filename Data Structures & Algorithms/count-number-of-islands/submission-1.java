class Solution {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int noOfIsLands= 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]== '1' && !visited[i][j]){
                    calculateIsLand(grid, visited, i, j);
                    noOfIsLands++;
                }
            }
        }
        return noOfIsLands;
        
    }

    public void calculateIsLand(char[][] grid, boolean[][] visited,int i, int j){
        if(i<0 || j<0 || i>=grid.length|| j>=grid[0].length||visited[i][j]||grid[i][j]!='1'){
            return;
        }

        visited[i][j] = true;
        calculateIsLand(grid, visited, i+1,j);
        calculateIsLand(grid, visited, i-1,j);
        calculateIsLand(grid, visited, i,j+1);
        calculateIsLand(grid, visited, i,j-1);
    }
}
