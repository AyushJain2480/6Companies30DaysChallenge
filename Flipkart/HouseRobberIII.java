// TLE - Recursion
class Solution {
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        
        // case 1 : rob root node and its grandchildren
        int robCurrent = root.val;
        if(root.left != null)
            robCurrent += rob(root.left.left) + rob(root.left.right);
        
        if(root.right != null)
            robCurrent += rob(root.right.left) + rob(root.right.right);
        
        // case 2: rob childnodes only
        int doNotRobCurrent = 0;
        doNotRobCurrent += rob(root.left) + rob(root.right);
        
        // find the maxm amount you can get from both the cases
        return Math.max(robCurrent , doNotRobCurrent);
    }
}

// Memoization
