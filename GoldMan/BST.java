class Solution {

// Approach 
// Traverse the first tree - O(M) - store in list
// Traverse the second tree - O(N) - store in same list
// O(M + N)
// Using quickSort O(M+N(log(M + N)))  
// O(M + N + O((M + N)(log(M + N)))) --> O(M+N(log(M + N))) 
    
        
// Approach 2
// Traverse the first tree - O(M) - store in arr1
// Traverse the second tree - O(N) - store in arr2
// O(M + N)
// Traverse arr1 and arr2 and merge them in a sorted way
// which takes O(M + N)
// O(2(M + N)) --> O(M + N) 

// Approach 3
// TC - O(M + N).
// SC is slightly optimised in average case O(H1 + H2)
// but in worst case when it is skewed tree it is O(M + N)

    
List<Integer> list = new LinkedList<>();
    
    // public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    //     preOrder(root1);
    //     preOrder(root2);
    //     Collections.sort(list);
    //     return list; 
    // }
    
    // public void preOrder(TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     preOrder(root.left);
    //     list.add(root.val);
    //     preOrder(root.right);
    // }
  
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      ArrayList<Integer> list1 = new ArrayList<>();
      ArrayList<Integer> list2 = new ArrayList<>();
      ArrayList<Integer> res = new ArrayList<>();
      preOrder(root1,list1);
      preOrder(root2,list2);
      int i = 0;
      int j = 0;
      while(i < list1.size() && j < list2.size()){
        if(list1.get(i) <= list2.get(j)){
            res.add(list1.get(i));
            i++;
        }
        else if(list2.get(j) < list1.get(i)){
            res.add(list2.get(j));
            j++;
        }
      }
      while(i < list1.size()){
          res.add(list1.get(i));
          i++;
      }
      while(j < list2.size()){
          res.add(list2.get(j));
          j++;
      }
    return res;
    }
    public void preOrder(TreeNode root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        preOrder(root.left,list);
        list.add(root.val);
        preOrder(root.right,list);
    }
}
