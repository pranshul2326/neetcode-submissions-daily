class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;


        boolean[][] atlantic = new boolean[n][m];
        boolean[][] pacific = new boolean[n][m];        

        //first row (r,c)
        for(int i=0;i<n;i++){   
            dfs(heights,pacific,i,0);

        }

        //first coll
        for(int i=0;i<n;i++){
             dfs(heights,pacific,0,i);


        }

        //last row
        for(int i=0;i<n;i++){
            dfs(heights,atlantic,i,m-1);

        }

        //last col
        for(int i=0;i<n;i++){
            dfs(heights,atlantic,n-1,i);
        }
   
   List<List<>> ans = new LinkedList<>();

   for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        if(atlantic[i][j] && pacific[i][j]){
            ans.add(Arrays.asList(i,j));
        }
    }
   }
}


}
