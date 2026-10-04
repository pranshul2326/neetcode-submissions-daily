class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] lse = new int[n];

        //nse
        Stack<Integer> st  = new Stack<>();
        nse[n-1] = n;
        st.push(n-1);
        for(int i = n-2;i>=0;i--){
            while(st.size()>0 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.size()==0){
                nse[i] = n;
            }else{
                nse[i]=st.peek();
            }
            st.push(i);
        }

        Stack<Integer> stk  = new Stack<>();
        lse[0] = -1;
        stk.push(0);
        for(int i = 1;i<n;i++){
            while(stk.size()>0 && heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            if(stk.size()==0){
                lse[i] = -1;
            }else{
                lse[i]=stk.peek();
            }
            stk.push(i);
        }


        int sum = 0;
        for(int i=0;i<n;i++){
            int area = (nse[i]-lse[i]-1)*heights[i];
            sum = Math.max(sum, area);
        }
        return sum;
        
    }
}
