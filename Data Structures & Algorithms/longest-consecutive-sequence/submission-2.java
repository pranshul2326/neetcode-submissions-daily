class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        List<Integer> list = new ArrayList<>();
        for(int val : nums){
            if(!set.contains(val-1)){
                list.add(val);
            }
        }
        int count = 0;
        int ans = 0;
        for(int num : list){
            while(set.contains(num)){
                count++;
                num++;
                ans = Math.max(ans,count);
            }
            count = 0;

        }
        return ans;

    }
}
