class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lnge = new int[n];
        int[] rnge = new int[n];

        for(int i=0;i<n;i++){
            if(i==0){
                lnge[i] = height[0];
            }else{
                lnge[i] = Math.max(height[i],lnge[i-1]);
            }
        }

        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                rnge[i]=height[i];
            }else{
                rnge[i] = Math.max(height[i],rnge[i+1]);

            }
        }
        int ans  = 0;
        for(int i=0;i<n;i++){
            // System.out.println(lnge[i]+"<--"+i+"-->"+rnge[i]);
            int v = Math.min(lnge[i],rnge[i])-height[i];
            // System.out.println("sum"+v);
            ans += v;
        }

        return ans;
    }
}
