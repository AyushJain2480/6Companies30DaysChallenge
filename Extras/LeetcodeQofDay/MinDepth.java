class Solution{
public int minDepth(TreeNode root) {
    if (root == null)
        return 0;
    
    int left = minDepth(root.left);
    int right = minDepth(root.right);
    
    if(left != 0 && right != 0){
        return Math.min(left,right) + 1;
    }
    // ek side 0 he or ek side koi number that means ki us number par nearest leaf node he to vo ans hoga 
  
    if(left == 0){
        return right + 1; // nearest num is at the right and 1 is added for rootnode
    }
    if(right == 0){
        return left + 1; // nearest num is at the left and 1 is added for rootnode
    }
    
    // return Math.max(left ,right) + 1;
}
}
