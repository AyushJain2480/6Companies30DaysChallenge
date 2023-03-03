// inorder traversal of Binary search tree will give you elements in ascending order 
// but for general binary tree it may not be true.
class Solution {
    Set<Integer> set = new HashSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        inorder(root);
        if(set.size() < 2) return -1;
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.get(1);
    }
    public void inorder(TreeNode root){
        if(root == null)return;
        inorder(root.left);
        set.add(root.val);
        inorder(root.right);
    }
}
