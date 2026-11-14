class Solution {
    public int leastInterval(char[] arr, int n) {


HashMap<Character, Integer> map = new HashMap<>();

    int maxFreq = 0;
    char maxChar = ' ';

    for (char ch : arr) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);

        if (map.get(ch) > maxFreq) {
            maxFreq = map.get(ch);
            maxChar = ch;
        }
    }

    int idea_space = (maxFreq - 1)*n;
    for(char ch : map.keySet()){
        if(ch == maxChar) continue;

        idea_space -= Math.min(map.get(ch),maxFreq - 1 );
    }
    if(idea_space<0){
        idea_space = 0;
    }
    return  idea_space + arr.length;
    }
}
