// using backtracking 30ms
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
       inorder(root, new StringBuilder());
       return sum;
    }
    
    public void inorder(TreeNode root , StringBuilder sb){
        if(root == null){
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null){
            sum += Integer.valueOf(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        inorder(root.left, sb);
        inorder(root.right , sb);
        sb.deleteCharAt(sb.length() - 1); 
    }
}
