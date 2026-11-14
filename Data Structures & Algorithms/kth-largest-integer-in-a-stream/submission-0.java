class KthLargest {

    PriorityQueue<Integer> queue;
    int cnt;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>((a,b)->b-a);
        for (int num : nums) {
            add(num);
        }
        cnt = k;
    }
    
    public int add(int val) {
        queue.add(val);
        PriorityQueue<Integer> temp = new PriorityQueue<>(queue);
        for(int i=1;i<=cnt-1;i++){
            temp.poll();
        }
        return temp.poll();
        
    }
}
