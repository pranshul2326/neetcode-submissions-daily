class Solution {
    public boolean isPalindrome(String str) {
        int i =0,j=str.length()-1;
        
        while(i<=j){
            char s = str.charAt(i);
            char e = str.charAt(j);
            if(!Character.isLetterOrDigit(s)) i++;
            else if(!Character.isLetterOrDigit(e)) j--;
            else if(Character.toLowerCase(s)!=Character.toLowerCase(e)) return false;
            else {i++; j--;}
        }
        return true;
        
    }
}
