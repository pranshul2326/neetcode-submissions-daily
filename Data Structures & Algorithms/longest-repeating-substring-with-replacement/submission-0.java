class Solution {
    public int characterReplacement(String s, int k) {
        int n  = s.length();
        int[] freq = new int[26];
        int maxfreq = 0;
        int j =0;
        int window = 0;
        int maxlen = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int idx = ch - 'A';

            freq[idx]++;
            maxfreq = Math.max(maxfreq,freq[idx]);


            window = i - j +1;

            if(window-maxfreq>k){
                freq[j]--;
                j++;
            }else{
                maxlen = Math.max(maxlen,i - j +1 );
            }







        }

        return maxlen;
        
    }
}
