class Solution {
    public boolean isValid(String s) {
        Stack<Character> st =  new Stack<>();
        if(s.length()%2!=0) return false;
        for(char ch : s.toCharArray())
        if(ch == '['||ch == '('||ch == '{'){
            st.push(ch);
        }else{
            // if(ch != st.pop()){
            //     return false;
            // }
            if(st.size()==0) return false;
            char ch1 = st.pop();
            if((ch == ']' && ch1=='[') || (ch == '}' && ch1=='{')||(ch == ')' && ch1=='(') ){
                continue;
            }else{
                return false;
            }
        }

        return st.size()==0?true:false;
        
    }
}
