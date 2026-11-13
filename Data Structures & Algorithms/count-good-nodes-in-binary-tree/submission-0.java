/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root,Integer.MIN_VALUE);
        
    }

    int helper(TreeNode root, int max){
        if(root == null) return 0;
        int cnt = 0;
        if(root.val>= max){
            cnt = 1;
        }

        int sum = 0;
        max = Math.max(max, root.val);
        int l = helper(root.left, max);
        int r = helper(root.right, max);

        sum = l+r+cnt;


        return sum;
    }
}
