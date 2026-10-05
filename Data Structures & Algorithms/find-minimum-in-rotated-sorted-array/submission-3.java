class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n-1;
        int min_value = Integer.MAX_VALUE;
        if(nums[0]<nums[n-1]){
            return nums[0];
        }
        while(lo<=hi){
            int mid = (lo+hi)/2;
            min_value = Math.min(nums[mid],min_value);
            if(nums[mid]>nums[lo]){
                lo = mid+1;

            }else{
                hi=mid-1;
            }

        }
        return min_value;
        
    }
}
