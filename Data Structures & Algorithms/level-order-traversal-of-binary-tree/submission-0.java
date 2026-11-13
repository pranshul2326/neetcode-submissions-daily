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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        if (root == null) return ans;
        List<Integer> ans_min = new ArrayList<>();
        while(queue.size()>0){
            TreeNode temp = queue.poll();
            if(temp == null){
                ans.add(ans_min);
                ans_min = new ArrayList<>();
                // queue.add(null);
                if (!queue.isEmpty()) {
                queue.add(null);
            }


            }else{
                ans_min.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }


        }
        return ans;
        
    }
}
