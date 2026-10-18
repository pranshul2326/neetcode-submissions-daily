
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            freq[ch - 'a']++;
        }


        int[] temp_freq = new int[26];
        int j=0;
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            temp_freq[ch - 'a']++;

            if(i-j+1>s1.length()){
                char ch_last = s2.charAt(j);
                temp_freq[ch_last - 'a']--;
                j++;
            }

            if(i-j+1==s1.length() && Arrays.equals(freq, temp_freq)){
                return true;
            }
            
        }

        return false;
    }
}
