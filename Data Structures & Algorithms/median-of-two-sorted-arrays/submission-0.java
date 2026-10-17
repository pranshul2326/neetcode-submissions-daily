class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {

        // Always binary search on the smaller array
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }

        int n = A.length + B.length ; 
        int l = 0;
        int h = A.length;

        while(l<=h){
            int mid = (l+h)/2; //2
            int mid2 = (n + 1) / 2 - mid;
            int al = mid == 0 ? Integer.MIN_VALUE : A[mid - 1];
            int ar = mid == A.length ? Integer.MAX_VALUE : A[mid];

            int bl = mid2 == 0 ? Integer.MIN_VALUE : B[mid2 - 1];
            int br = mid2 == B.length ? Integer.MAX_VALUE : B[mid2];

            if(al <= br && bl <= ar){
                if (n % 2 == 0) {
                    double medium = ((double) Math.max(al, bl)
                            + Math.min(ar, br)) / 2.0;
                    return medium;
                } else {
                    return Math.max(al, bl);
                }

            }else if(al > br){
                h = mid-1;
            }else{
                l = mid+1;
            }

        }
        return 0.0;

    }
}
