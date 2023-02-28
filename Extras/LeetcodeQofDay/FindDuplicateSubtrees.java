class Solution{
    ArrayList<TreeNode> res = new ArrayList<>();
    HashMap<String , Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        duplicates(root);
        return res;
    }

    public String duplicates(TreeNode root){
        if(root == null){
            return "N";
        }
        String left = duplicates(root.left);
        String right = duplicates(root.right);
        String curr = root.val + " " + left + " " + right;
        map.put(curr , map.getOrDefault(curr ,0) + 1);
        if(map.get(curr) == 2){
            res.add(root);
        }
        return curr;
    }
}
