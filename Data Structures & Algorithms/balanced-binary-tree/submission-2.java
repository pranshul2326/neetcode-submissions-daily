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
    boolean is_balanced = true;
    public boolean isBalanced(TreeNode root) {

        // approach 1 tc => N^2
        // if (root == null) return true;
        // int left_h = root !=null ? height(root.left):0;
        // int right_h = root !=null ? height(root.right):0 ;

        // if(Math.abs(left_h - right_h)>1 || !isBalanced(root.right) ||  !isBalanced(root.left)){
        //     return false;
        // }
        // return true;


        // approach -1 -> TC => N
        if (root == null) return true;
        int left_h = root !=null ? height(root.left):0;
        int right_h = root !=null ? height(root.right):0 ;
        if(!is_balanced) return false;

        if(Math.abs(left_h - right_h)>1){
            return false;
        }
        return is_balanced;
    }

    int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = height(root.left);
        int r = height(root.right);
        if(Math.abs(l-r)>1){
            is_balanced = false;
        }

        return Math.max(l,r)+1;
    }
}
