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

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        List<List<Integer>> reverseList = new ArrayList<>();
        for(List<Integer> list : res){
            reverseList.add(0,list);
        }
        return reverseList;
    }
}
// simple no need to store every elements of each level store the first element of each level or just update it.
class Solution {
    Queue<TreeNode> queue = new LinkedList<>();
    int result = 0;
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode pop = queue.poll(); 
                if(i == 0) result = pop.val; // update the first value of each lvl 1,2,4,7
                if(pop.left != null){
                    queue.offer(pop.left);
                }
                if(pop.right != null){
                    queue.offer(pop.right);
                }
            }
        }
        return result; // at last level it is updated with 7 
    }
}

