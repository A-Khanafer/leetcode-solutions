/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        findPath(root,p,pathP);
        findPath(root,q,pathQ);

        TreeNode lca = null;
        for(int i=0; i < Math.min(pathQ.size(), pathP.size()); i++ ){
            if(pathQ.get(i) != pathP.get(i)){
                break;
            }
            lca = pathP.get(i);
        }

        return lca;
    }

    private boolean findPath(TreeNode root,  TreeNode target, List<TreeNode> path) {

        if(root == null){
            return false;
        } 
        path.add(root);

        // Target found
        if (root == target) {
            return true;
        }

        // Search left subtree
        if (findPath(root.left, target, path)) {
            return true;
        }

        // Search right subtree
        if (findPath(root.right, target, path)) {
            return true;
        }

        // Neither subtree contains target
        path.remove(path.size() - 1);
        return false;

    }
}