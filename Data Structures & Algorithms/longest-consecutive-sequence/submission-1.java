class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        //nums => 2,3,4,4,5,10,20
        int count = 1;
        int ans = count; //1
        int val = nums[0]; //2
        for(int v: nums){
            if(v==val+1){
                count++;
                val++;
                ans = Math.max(ans,count);
            }if(v==val){
                continue;
            }
            else{
                val = v;
                count =1;
            }
            


        }
        return ans;
        
    }
}
