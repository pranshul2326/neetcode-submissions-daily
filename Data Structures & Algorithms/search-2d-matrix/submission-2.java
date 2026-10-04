class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j = matrix[0].length * matrix.length-1;
        while(i<=j){
            int mid = i + (j-i)/2;
            int r = mid / matrix[0].length;
            int c = mid % matrix[0].length;
            int val = matrix[r][c];
            if(val>target){
                j= mid -1;
            }else if(val<target){
                i = mid +1;
            }else{
                return true;
            }
        }
        return false;
        
    }
}
