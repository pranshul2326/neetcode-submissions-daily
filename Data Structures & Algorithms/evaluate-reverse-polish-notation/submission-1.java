class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(String val : tokens){
            if(val.equals("+")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push(v1+v2);

            }else if(val.equals("-")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push(v2-v1);

            }else if(val.equals("*")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push(v1*v2);

            }else if(val.equals("/")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push(v2/v1);

            }
            else{
                int value = Integer.parseInt(val);
                st.push(value);
            }
            

        }
        return st.pop();
    }
}
