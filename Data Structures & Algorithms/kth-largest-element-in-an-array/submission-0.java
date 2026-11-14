class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->a-b);
        
        for(int val : nums){
            int size = q.size();
            if(size<k){
                q.add(val);
            }else{
                q.poll();
                q.add(val);
            }


        }
        System.out.println(q.size());
        // for(int i =1;i<=k-1;i++){
        //     q.poll();
        // }
        return q.peek();
        
    }
}
