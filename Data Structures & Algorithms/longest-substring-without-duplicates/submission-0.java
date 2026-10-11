class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i =0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for(int k=0;k<s.length();k++){
            char ch = s.charAt(k);
            if(set.contains(ch)){
                set = new HashSet<>();
            }
                set.add(ch);
            

            max = Math.max(max, set.size());


        }
        return max;
        
    }
}
