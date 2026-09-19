class Solution {

    public String encode(List<String> strs) {
        String ans = "";
        for(String s : strs){
            int len = s.length();
            ans+=len+"*"+s;
        }

        return ans;

    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int first = 0;
        int i =0;
        int j =0;

        while(i<str.length()){
j=i;
            while(str.charAt(j)!='*'){
                j++;//3
            }

            

            int fChLen = Integer.parseInt(str.substring(i,j));





            String nextStr = str.substring(j+1,j+fChLen+1);
            ans.add(nextStr);
            nextStr = "";
            i = j+fChLen+1;
        }
        return ans;


    }
}
