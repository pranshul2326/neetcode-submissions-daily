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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(map, 0, preorder.length-1, preorder);
    }

    TreeNode helper(HashMap<Integer,Integer> map, int l, int r,int[] preorder){
        if(l>r){
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx]);
        int mid = map.get(preorder[idx]);
        idx++;
        root.left = helper(map, l,mid-1, preorder );
        root.right = helper(map, mid+1, r, preorder);

        return root;


    }
}
