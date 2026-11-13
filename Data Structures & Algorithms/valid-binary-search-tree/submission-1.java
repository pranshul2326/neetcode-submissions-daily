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
    public boolean isValidBST(TreeNode root) {

        // if(root == null){
        //     return true;
        // }
        // boolean l = root.left !=null? isValidBST(root.left): true;
        // boolean r = root.right !=null? isValidBST(root.right): true;

        // if(l && r && root.val< root.left.val && root.val>root.right.val){
        //      return true;
        // }

        // return false;
        // return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    boolean helper(TreeNode root, long min, long max){

        if(root == null){
            return true;
        }

        if(root.val<=min || root.val>=max){
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
