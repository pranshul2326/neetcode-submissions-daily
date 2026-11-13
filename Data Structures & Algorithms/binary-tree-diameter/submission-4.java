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
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        // if (root == null) {
        //     return 0;
        // }

        // int leftHeight = height(root.left);
        // int rightHeight = height(root.right);

        // // What should you do here?
        // dia = Math.max(
        //     Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)),
        //     leftHeight+rightHeight
        // );
        dia = 0 ;
        height(root);
        return dia;
        
    }

int height(TreeNode root) {
    if(root == null) return 0;
    // Calculate left height
    int left_h = height(root.left);

    // Calculate right height
    int right_h = height(root.right);

    // Update global diameter
    if(dia<left_h+right_h){
        dia = left_h+right_h;
    }

    // Return current height
    return Math.max(left_h, right_h)+1;

}
}
