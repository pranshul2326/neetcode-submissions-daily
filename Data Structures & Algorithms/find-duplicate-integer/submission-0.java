class Solution {
    public int findDuplicate(int[] nums) {


        // Step 1: Initialize slow and fast pointers
        int slow = 0;
        int fast = 0;

        // Step 2: Find the meeting point inside the cycle
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);


        // Step 3: Reset slow to the starting position (0)
        fast = 0;

        // Step 4: Move both pointers one step at a time

        // until they meet again

        while(fast!=slow){
            slow = nums[slow];
            fast = nums[fast];
        }

        // Step 5: Return the duplicate number
        return slow;

        
    }
}
