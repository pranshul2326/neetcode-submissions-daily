class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // int i=0;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int k = i+1;
            int j = nums.length-1;

            while(k<j){
                if(nums[i]+nums[j]+nums[k]>0){
                    j--;
                }else if(nums[i]+nums[j]+nums[k]<0){
                    k++;
                }else{
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[i]);
                    pair.add(nums[j]);
                    pair.add(nums[k]);
                    
                    ans.add(pair);
                    j--;
                    k++;
                    while(k<j && nums[j]==nums[j+1]){
                         j--;
                    }
                    while(k<j && nums[k]==nums[k-1]){
                        k++;
                    }

                }

                
            }

        }
        return ans;
        
    }
}
