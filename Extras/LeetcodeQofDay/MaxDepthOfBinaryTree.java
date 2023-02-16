class Solution {
    int maxCount = 0;
    public int maxDepth(TreeNode root) {
       maxDep(root, 0); 
       return maxCount; 
    }
    
    public void maxDep(TreeNode root , int count){
         if(root == null){
             return;
         }
         count++;
         maxCount = Math.max(count , maxCount);
         maxDep(root.left , count);
         maxDep(root.right , count);
    }
}


class Solution {
    public int maxDepth(TreeNode root) {
      if(root == null){
          return 0;
      }
      int left = maxDepth(root.left);
      int right = maxDepth(root.right);
      return Math.max(left , right) + 1;  
    }
}
