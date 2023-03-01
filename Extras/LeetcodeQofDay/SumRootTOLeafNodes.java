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

// 100 ms solution 
  class Solution{
  public int sumNumbers(TreeNode root) {
    return sumNodes(root, 0);
  }

  private int sumNodes(TreeNode root, int currentSum) {
    if (root == null) return 0;
    currentSum = currentSum * 10 + root.val;
    if (root.left == null && root.right == null) return currentSum;
    int leftSum = sumNodes(root.left, currentSum);
    int rightSum = sumNodes(root.right, currentSum);
    return leftSum + rightSum;
  }
  }
