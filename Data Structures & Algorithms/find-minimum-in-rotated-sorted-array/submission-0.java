class Solution {
    public int findMin(int[] nums) { 
        int n = nums.length;
        int i = 0,j=n-1;
        int min = Integer.MAX_VALUE;
        while(i<j){
            int mid =  i + (j-i)/2;
            int mid_value = nums[mid];
            if(mid_value<nums[j]){
                j = mid-1;
            }else if(mid_value>nums[i]){
                i = mid +1;
            }
            min = Math.min(min,mid_value);

        }

        return min;
        
    }
}
