class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums,0,new ArrayList<Integer>(),subset);
        return subset;
    }

    public void findSubsets(int[] nums, int idx, List<Integer> list, List<List<Integer>> subset){

        subset.add(new ArrayList<>(list));

        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            findSubsets(nums,i+1,list, subset);
            list.remove(list.size()-1);
            
            
        }

    }
}
