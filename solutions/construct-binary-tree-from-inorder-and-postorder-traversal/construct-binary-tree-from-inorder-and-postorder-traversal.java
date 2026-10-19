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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder,
                     0, inorder.length - 1,
                     0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder,
                           int inStart, int inEnd,
                           int postStart, int postEnd) {

        // No elements left in this subtree
        if (inStart > inEnd) {
            return null;
        }

        // Last postorder element is the root
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // Find root in inorder
        int rootIndex = inStart;
        while (inorder[rootIndex] != rootVal) {
            rootIndex++;
        }

        // Calculate left subtree size
        int leftSize = rootIndex - inStart;

        // Reconstruct left subtree
        root.left = build(
            inorder, postorder,
            inStart, rootIndex - 1,
            postStart, postStart + leftSize - 1
        );

        // Reconstruct right subtree
        root.right = build(
            inorder, postorder,
            rootIndex + 1, inEnd,
            postStart + leftSize, postEnd - 1
        );

        return root;
    }
}