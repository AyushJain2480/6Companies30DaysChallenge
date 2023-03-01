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

// for the input [4,9,5,0,5,1], the function sumNumbers will compute the sum of all root-to-leaf paths. Here are the steps it takes:

// sumNumbers(root) is called with the root node, which has a value of 4.

// sumNodes(root, 0) is called, where currentSum is initially 0.

// The value of the root node, 4, is added to currentSum, which becomes 4.

// Since the root has both left and right children, we recursively call sumNodes on both children, passing currentSum as a parameter.

// a. For the left child, which has a value of 9, we add 9 to the currentSum of 4, to get a new currentSum of 49.

// b. The left child has two children of its own, so we recursively call sumNodes on both of them, passing the new currentSum of 49 as a parameter.

// i. For the left child of the left child, which has a value of 5, we add 5 to the currentSum of 49, to get a new currentSum of 495.

// ii. The left child of the left child has no children of its own, so we return the currentSum of 495 to the calling function.

// iii. For the right child of the left child, which has a value of 1, we add 1 to the currentSum of 49, to get a new currentSum of 491.

// iv. The right child of the left child has no children of its own, so we return the currentSum of 491 to the calling function.

// c. We add the result of both recursive calls (495 + 491) to get a leftSum of 986.

// d. For the right child, which has a value of 0, we add 0 to the currentSum of 4, to get a new currentSum of 40.

// e. The right child has no children of its own, so we return the currentSum of 40 to the calling function.

// We add the result of both recursive calls (986 + 40) to get a total sum of 1026, which is returned as the final answer.

// So the root-to-leaf paths that are considered in this case are:

// 4->9->5, which represents the number 495
// 4->9->1, which represents the number 491
// 4->0, which represents the number 40
// And the sum of all these numbers is 495 + 491 + 40 = 1026.
    
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


 // sum of root to leaf binary nodes
  class Solution{
  public int sumRootToLeaf(TreeNode root) {
    return sumNodes(root, 0);
  }

  private int sumNodes(TreeNode root, int currentSum) {
    if (root == null) return 0;
    currentSum = currentSum * 2 + root.val;
    if (root.left == null && root.right == null) return currentSum;
    int leftSum = sumNodes(root.left, currentSum);
    int rightSum = sumNodes(root.right, currentSum);
    return leftSum + rightSum;
  }
  }
