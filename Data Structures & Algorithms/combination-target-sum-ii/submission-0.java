
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        
        // Step 1: Sort the array so duplicates are adjacent
        Arrays.sort(candidates);
        
        backtracking(candidates, 0, new ArrayList<>(), target, combinations);
        return combinations;  
    }

    public void backtracking(int[] nums, int idx, List<Integer> psf, int target, List<List<Integer>> combinations) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            combinations.add(new ArrayList<Integer>(psf));
            return; // Stop and return when target is met
        }

        for (int i = idx; i < nums.length; i++) {
            // Step 2: Skip duplicate elements at the same recursion level to avoid duplicate combinations
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            psf.add(nums[i]);
            // Pass i + 1 because each element can be used at most once
            backtracking(nums, i + 1, psf, target - nums[i], combinations);
            psf.remove(psf.size() - 1); // Backtrack
        }
    }
}