// The inorder traversal is being used in this code because it visits the nodes in ascending order. Since we want to find the kth smallest element in the binary tree, we need to visit the nodes in ascending order so that we can keep track of the count as we traverse the tree.
// what does it mean ? it means it will traverse the smallest node first
// than greater than that than greater than that i.e in ascending order it will
// traverse so when it visit the first smallest 1 node we will count it as 1
// now going in ascending order it will visit 2 so we count it as 2
// now going in ascending order it will visit 3 so we count it as 3rd smallest
// as we want the 3rd smallest number our ans is ready.
class Solution{
int count = 0;
int result = Integer.MIN_VALUE;

public int kthSmallest(TreeNode root, int k) {
    traverse(root, k);
    return result;
}
// after visiting the leftest node you want to increase count
// reach 1 count = 1
// reach 2 count = 2    
// reach 3 count = 3
// if(count == 3) result = 3
public void traverse(TreeNode root, int k) {
    if(root == null) return;
    traverse(root.left, k);
    count++;
    if(count == k) result = root.val;
    traverse(root.right, k);       
}
}
