class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(nums,0,new ArrayList<>(),target,combinations);
        return combinations;  
    }

    public void backtracking(int[] nums,int idx,List<Integer> psf,int target, List<List<Integer>> combinations){
        if(target<0){
            return;
        }

        if(target==0){
            combinations.add(new ArrayList<Integer>(psf));
        }

        for(int i=idx;i<nums.length;i++){
            psf.add(nums[i]);
            backtracking(nums,i,psf,target-nums[i],combinations);
            psf.remove(psf.size()-1);

        }
    }


}
