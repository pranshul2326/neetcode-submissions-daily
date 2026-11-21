// class Solution {
    
//     public List<List<Integer>> pacificAtlantic(int[][] height) {
//         int n = height.length;
//         int m = height[0].length;
//         List<List<Integer>> ans  = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(isPacific(height,i,j) && isAtlantic(height,i,j)){
//                     System.out.println("i :"+i+",  j :"+j);
//                     System.out.println(isPacific(height,i,j));
//                     System.out.println(isAtlantic(height,i,j));
//                     List<Integer> point = new ArrayList<Integer>();
//                     point.add(i);
//                     point.add(j);
//                     ans.add(point);
//                 }
//             }
//         }
//         return ans;
        
//     }
//      boolean isPacific(int[][] height, int i, int j){
//         if(i<=0 || j<=0){
//             return true;
//         }
//         boolean top = height[i][j-1] <= height[i][j] ? isPacific(height, i, j-1) : false;
//         boolean left = height[i-1][j] <= height[i][j] ? isPacific(height,i-1,j) : false;

//         if(top||left){
//             return true;
//         }
//         return false;
//      }

//      boolean isAtlantic(int[][] height, int i, int j){
//         if(i>=height.length-1 || j>=height[0].length-1){
//             return true;
//         }
//         boolean bottom = height[i][j+1] <= height[i][j] ? isPacific(height, i, j+1) : false;
//         boolean right = height[i+1][j] <= height[i][j] ? isPacific(height,i+1,j) : false;

//         if(bottom||right){
//             return true;
//         }
//         return false;

//      }
// }


class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] height) {

        int n = height.length;
        int m = height[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (isPacific(height, i, j) &&
                    isAtlantic(height, i, j)) {

                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);

                    ans.add(point);
                }
            }
        }

        return ans;
    }

    boolean isPacific(int[][] height, int i, int j) {

        if (i == 0 || j == 0) {
            return true;
        }

        // Up
        boolean up = height[i-1][j] <= height[i][j]
                && isPacific(height, i-1, j);

        // Left
        boolean left = height[i][j-1] <= height[i][j]
                && isPacific(height, i, j-1);

        return up || left;
    }

    boolean isAtlantic(int[][] height, int i, int j) {

        int n = height.length;
        int m = height[0].length;

        if (i == n-1 || j == m-1) {
            return true;
        }

        // Down
        boolean down = height[i+1][j] <= height[i][j]
                && isAtlantic(height, i+1, j);

        // Right
        boolean right = height[i][j+1] <= height[i][j]
                && isAtlantic(height, i, j+1);

        return down || right;
    }
}
