class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int v: nums){
            map.put(v,map.getOrDefault(v,0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];

        for(int num:map.keySet()){
            int freq = map.get(num);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        int[] ans= new int[k];
        int i=0;
        for(int j=nums.length;j>0 && i<k;j--){
            if(bucket[j]!=null){
                for(int vals : bucket[j]){
                    ans[i]=vals;
                    i++;
                    if(i==k){
                        break;
                    }
                }

            }
        }
        return ans;

        
    }
}
