// First level is not zigzag
// than next level is zigzag
//                not zigzag
//                    zigzag like this 
// so if the level is not zigzag add the elements from left to right adding in the last position
// and if the level is zigzag add the elements from right to left addding in the first position 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        queue.offer(root);
        boolean zigzag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>(); // list for each level 
            for(int i = 0; i < size; i++){
                TreeNode pop = queue.poll();
                level.add(pop.val); 
                if(pop.left != null){
                    queue.offer(pop.left);
                }
                if(pop.right != null){
                    queue.offer(pop.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        queue.offer(root);
        boolean zigzag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>(); // list for each level 
            for(int i = 0; i < size; i++){
                TreeNode pop = queue.poll();
                if(!zigzag){
                    level.add(pop.val); 
                }else{
                    level.add(0,pop.val);
                }
                if(pop.left != null){
                    queue.offer(pop.left);
                }
                if(pop.right != null){
                    queue.offer(pop.right);
                }
            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
    }    
}


