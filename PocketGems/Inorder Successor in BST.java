/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode node = inorderSuccessor(root.left, p);
        return node == null ? root : node;
        
        
        
        //follow up : with parent node

        if (root == null) {
            return root;
        }
        if (p.right != null) {
            return findMin(p.right);
        }
        TreeNode parent = p.parent;
        // with value : while (parent != null && p.val > parent.val)
        while (parent != null && parent.right == p) {
            p = parent;
            parent = p.parent;
        }
        return p;
        /*
        if (root == null) {
            return root;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
        */
    }
}