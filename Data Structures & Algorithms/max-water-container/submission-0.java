class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j = heights.length-1;
        int maxArea =0, area = 0;
        while(i<j){
            int b = j-i;
            int l = Math.min(heights[i],heights[j]);
            if(l==heights[i]){
                i++;
            }else if(l==heights[j]){
                j--;
            }
            area = b*l;
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;

    }
}
