class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp_cost = new int[cost.length+1];
        dp_cost[0] = cost[0];
        dp_cost[1] = cost[1];
        for(int i=2;i<=cost.length;i++){
           
            if(i==cost.length){
                 dp_cost[i] = Math.min(dp_cost[i-1],dp_cost[i-2]);
            }else{
 dp_cost[i] = Math.min(dp_cost[i-1],dp_cost[i-2])+cost[i];
            }
        }

        return dp_cost[cost.length];

        
    }
}
