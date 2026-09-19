class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int val : nums) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int v : map.keySet()) {
            pq.add(v);
        }

        int[] ans = new int[k];
        for(int i =0;i<k;i++){
            ans[i]=pq.poll();
        }
        
        
        return ans;
    }
}
