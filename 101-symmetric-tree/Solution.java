class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelp(root, root);
    }

    public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.val == right.val && isSymmetricHelp(left.left, right.right)
                && isSymmetricHelp(left.right, right.left);
    }
}
