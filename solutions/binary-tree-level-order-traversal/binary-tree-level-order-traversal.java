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
import java.util.*;


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            
            //add its children
            for(int i = 0; i < levelSize ; i++){
                //Removes then Visits node
                TreeNode node = queue.poll();
                if(node.left != null){queue.offer(node.left);}
                if(node.right != null){queue.offer(node.right);}
                level.add(node.val);
            }

            result.add(level);
        }

        return result;
    }
}