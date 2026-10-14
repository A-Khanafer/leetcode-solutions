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
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int min = 100000;
        for(int i=1; i<list.size(); i++){
            if(list.get(i) -list.get(i-1) < min)min = list.get(i) -list.get(i-1);  
        }

        return min;
    }

    public void dfs(TreeNode node, List<Integer> result){
        if(node == null) return;
        dfs(node.left, result);
        result.add(node.val);
        dfs(node.right, result);
    }
}