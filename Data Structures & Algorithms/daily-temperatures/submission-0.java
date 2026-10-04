class Solution {
    public int[] dailyTemperatures(int[] temp) {

        int n = temp.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                st.push(i);
                ans[i]=0;
            }else{
                int val = temp[i];
                if(val<temp[st.peek()]){
                    
                    ans[i]=st.peek()-i;
                    st.push(i);
                }else{
                    while(st.size()>0 && val>=temp[st.peek()]){
                        st.pop();
                    }
                    int dist = st.size()>0? st.peek()-i:0;
                    ans[i] = dist;
                    st.push(i);
                }
            }
        }
        return ans;
        
    }
}
