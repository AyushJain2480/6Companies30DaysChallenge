class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
       return path(0 , root , targetSum);
    }
    
    public boolean path(int currSum , TreeNode root , int targetSum){
        if(root == null) return false;
        currSum += root.val;
        if(root.left == null && root.right == null && currSum == targetSum){
            return true;
        }
        return path(currSum , root.left ,targetSum) || path(currSum , root.right , targetSum);
    }
}
