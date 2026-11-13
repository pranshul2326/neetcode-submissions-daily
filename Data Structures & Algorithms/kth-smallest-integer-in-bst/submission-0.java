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
    int ans = 0;
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {

         helper(root, k);
         return ans;
        
    }

    void helper(TreeNode root, int k){
        if(root == null){
            return;
        }

        if(root.left!=null) helper(root.left, k);
        cnt = cnt +1;
        if(cnt == k){
            ans = root.val;
        }
        if(root.right!=null ) helper(root.right, k);

        

    }
}
