class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int i = 1;
        int j = piles[n-1];
        int k = j;
        while(i<=j){
            int k_temp = i + (j-i)/2;
            int time_taken = 0;
            for(int p = 0;p<n;p++){
                time_taken += (piles[p] + k_temp - 1) / k_temp;
            }
            if(time_taken > h){
                i = k_temp+1;
            }else{
                j = k_temp-1;
                k = k_temp;
            }
            // k = Math.min(k,k_temp);

        }
        return k;

        
        
    }
}
