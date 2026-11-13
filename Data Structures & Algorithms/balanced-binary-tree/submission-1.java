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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left_h = root !=null ? height(root.left):0;
        int right_h = root !=null ? height(root.right):0 ;

        if(Math.abs(left_h - right_h)>1 || !isBalanced(root.right) ||  !isBalanced(root.left)){
            return false;
        }
        return true;
    }

    int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r)+1;
    }
}
