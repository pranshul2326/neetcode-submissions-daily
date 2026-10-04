class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        int[] ans= new int[2];
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else{
                ans[0]=i+1;
                ans[1]=j+1;
                return ans;
            }
        }
        return ans;
    }
}
