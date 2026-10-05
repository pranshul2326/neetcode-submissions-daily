class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n-1;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;

            if(nums[mid] == target){
                return mid;
            }
//left sorted
            if(nums[lo]<=nums[mid]){
                if(target<nums[mid] && target>=nums[lo]){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }else{
                if(target>nums[mid] && target<=nums[hi]){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
                
            }


            
            

        }
        return -1;
        
    }
}
