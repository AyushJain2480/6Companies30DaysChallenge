class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path(0,root,targetSum , new ArrayList<Integer>());
        return res;
    }
    
    public void path(int currSum, TreeNode root , int targetSum , List<Integer> list){
        if(root == null) return;
        currSum += root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && currSum == targetSum){
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        path(currSum, root.left, targetSum, list);
        path(currSum, root.right, targetSum, list);
        list.remove(list.size() - 1);
    }
}
