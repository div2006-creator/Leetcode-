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
TreeNode first, second, prev;
public void recoverTree(TreeNode root) {
    first = null;
    second = null;
    prev = null;

    fun(root);

    int temp = first.val;
    first.val = second.val;
    second.val = temp;
}

void fun(TreeNode root) {
    if (root == null)
        return;

    fun(root.left);

    if (prev != null && prev.val > root.val) {
        if (first == null)
            first = prev;

        second = root;
    }

    prev = root;

    fun(root.right);
}
}
