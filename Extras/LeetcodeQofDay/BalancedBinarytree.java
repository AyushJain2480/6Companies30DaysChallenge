class Solution {
    public boolean isBalanced(TreeNode root) {
    if (root == null) {
        return true; // empty tree is always balanced
    }
    
    int leftDepth = getDepth(root.left);
    int rightDepth = getDepth(root.right);
    
    // check if current node is balanced
    if (Math.abs(leftDepth - rightDepth) > 1) {
        return false;
    }
    
    // check if both subtrees are balanced
    return isBalanced(root.left) && isBalanced(root.right);
}

private int getDepth(TreeNode node) {
    if (node == null) {
        return 0; // depth of an empty subtree is 0
    }
    
    int leftDepth = getDepth(node.left);
    int rightDepth = getDepth(node.right);
    
    return Math.max(leftDepth, rightDepth) + 1; // depth of current node is maximum depth of its subtrees + 1
}
}
