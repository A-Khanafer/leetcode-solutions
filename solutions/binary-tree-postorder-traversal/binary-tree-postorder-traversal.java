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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        dfsPostOrder(root, result);

        return result;
    }

    private void dfsPostOrder(TreeNode node, List<Integer> result){
        if(node == null) return;
        dfsPostOrder(node.left, result);
        dfsPostOrder(node.right, result);
        result.add(node.val);
    }
}