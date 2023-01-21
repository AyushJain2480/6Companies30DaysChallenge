 // 17 ms 
class Solution {
   int sum = 0;
   int count = 0; 
   int ans = 0;

    public void inorderAverage(TreeNode root){   
        if(root == null){
            return;
        }
        inorderAverage(root.left);
        sum += root.val;
        count++; 
        inorderAverage(root.right);
    }
    Queue<TreeNode> queue = new LinkedList<>(); 
    public int averageOfSubtree(TreeNode root) {
       inorder(root); // 4
       // 0 8 1 4 5 6
       while(!queue.isEmpty()){
           TreeNode node = queue.poll();
           inorderAverage(node);
           if((sum/count) == node.val) ans++;
           sum = 0;
           count = 0;
       }
       return ans;
    }

    public void inorder(TreeNode root){   
    if(root == null){
        return;
    }
    inorder(root.left);
    queue.add(root);
    inorder(root.right);
    }
}
// Another solution
class Solution {
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        traversal(root);
        return ans;
    }
   
    public void traversal(TreeNode root){
        if(root == null){
            return;
        }
        if((sum(root) / count(root)) == root.val) ans++;
        traversal(root.left);
        traversal(root.right);
    }

    public int sum(TreeNode root){
       if(root == null) return 0;
       return sum(root.left) + sum(root.right) + root.val;
    }

    public int count(TreeNode root){
        if(root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
    
}
   
