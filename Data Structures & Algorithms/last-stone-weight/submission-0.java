class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int v : stones){
            pq.add(v);
        }

        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            if(a == b) continue;
            pq.add(Math.abs(a-b));
        }

        return pq.peek();
        
    }
}
