/**
 * Backtracking
 *
 * Time complexity = InternalNodes in the RecursionTree   +   K * LeafNodes in RecursionTree
 *                 = (C(9,0) + C(9,1) + ... + C(9,K-1))   +   K * C(9,K)
 * In our solution, the worst case will happen when k = 8. Then Total Time Complexity = O(574) which is O(1)
 *
 * Space Complexity = O(k) -> Depth of Recursion tree + Size of TempList
 *
 * K = Input size of each combination.
 */

/* 
 * At each step we have two choices either to select an element or reject it 
 * So the point of list.remove(list.size() - 1) is, after each "fail" or "success", since we don't need to do further attempts 
 * given such a condition, we delete the last element, and then end current backtracking. Next step is, add the next element 
 * to the deleted index, go on attempting.
 */

  
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1,n,new ArrayList<Integer>(), k , res);
        return res;
    }
   
    private void backtrack(int start , int sum , List<Integer> list , int k , List<List<Integer>> res){
      
     if(list.size() > k){
            return;
      }

    if(list.size() == k && sum == 0){
       List<Integer> li = new ArrayList<Integer>(list);
       res.add(li);
       return;
    }    
    for(int i = start; i <= 9; i++){
        if(i <= sum){
            list.add(i);
            backtrack(i + 1 , sum - i , list, k , res);
            list.remove(list.size() - 1);
        }
    }
    }
}
