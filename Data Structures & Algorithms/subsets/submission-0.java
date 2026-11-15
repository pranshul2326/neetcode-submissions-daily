class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> subset = new ArrayList<>();
        findAllSets(subset,new ArrayList<Integer>(),0,nums);
        return subset;
    }

    void findAllSets(List<List<Integer>> subset, List<Integer> list, int idx,int[] nums){

        subset.add(new ArrayList<>(list));


        for(int i=idx;i<nums.length;i++){
            list.add(nums[i]);
            findAllSets(subset, list, i+1,nums);
            list.remove(list.size()-1);
        }
    }
}
