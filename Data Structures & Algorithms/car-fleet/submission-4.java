class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cardata = new double[n][2];
        for(int i=0;i<n;i++){
            cardata[i][0] = (double)position[i];
            cardata[i][1] = (double)(target-position[i])/speed[i];
        }
        Arrays.sort(cardata,(a,b)->Double.compare(a[0],b[0]));
        Stack<Double> st = new Stack<>();

        int fleet = 0;
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                st.push(cardata[i][1]);
                fleet = 1;
            }else{

                double val = cardata[i][1];
                if(val <= st.peek()){
                    // st.push(cardata[i][1]);
                }else{
                    fleet++;
                    st.push(cardata[i][1]);
                }
            }
            // st.push(cardata[i][1]);
        }

        return fleet;
    }
}
