// When we perform level order traversal, we visit nodes from left to right at each level. So, by adding the last node of each level to the result list, we can ensure that we only add the nodes that are visible from the right side.
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> list = new ArrayList<>();
       if(root == null) return list; 
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       while(!queue.isEmpty()){
           int size = queue.size();
           while(size-- > 0){
               TreeNode pop = queue.poll();
               if(size == 0) list.add(pop.val);
               if(pop.left != null){
                   queue.offer(pop.left);
               }
               if(pop.right != null){
                   queue.offer(pop.right);
               }
           }
       }
       return list;
    }
}


