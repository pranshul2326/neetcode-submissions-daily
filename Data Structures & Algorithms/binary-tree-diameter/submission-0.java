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

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // What should you do here?
        dia = Math.max(dia, leftHeight+rightHeight);

        return dia;
        
    }

    int height(TreeNode root) {

    if (root == null) {
        return 0;
    }

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    // Update diameter using leftHeight + rightHeight
    return Math.max(leftHeight,rightHeight) + 1;

    // Return the height of current subtree
}
}
