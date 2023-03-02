class Solution {
    public int goodNodes(TreeNode root) {
        return preorder(root , Integer.MIN_VALUE);
    }
    public int preorder(TreeNode root , int max){
        if(root == null) return 0;
        int count = 0;
        if(root.val >= max){
           count++;
           max = root.val;
        }
        count += preorder(root.left , max) + preorder(root.right , max);
        return count;
    }
}
