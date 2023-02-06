// Step I -- Think naively

// At first glance, the problem exhibits the feature of "optimal substructure": if we want to rob maximum amount of money from current binary tree (rooted at root), 
// we surely hope that we can do the same to its left and right subtrees.

// So going along this line, let's define the function rob(root) which will return the maximum amount of money that we can rob for the binary tree rooted at root;
// the key now is to construct the solution to the original problem from solutions to its subproblems, i.e., how to get rob(root) from rob(root.left), 
// rob(root.right), ... etc.

// Apparently the analyses above suggest a recursive solution. And for recursion, it's always worthwhile figuring out the following two properties:

// Termination condition: when do we know the answer to rob(root) without any calculation? Of course when the tree is empty ---- we've got nothing to rob so the 
// amount of money is zero.

// Recurrence relation: i.e., how to get rob(root) from rob(root.left), rob(root.right), ... etc. From the point of view of the tree root, 
// there are only two scenarios at the end: root is robbed or is not. If it is, due to the constraint that "we cannot rob any two directly-linked houses", 
// the next level of subtrees that are available would be the four "grandchild-subtrees" (root.left.left, root.left.right, root.right.left, root.right.right).
// However if root is not robbed, the next level of available subtrees would just be the two "child-subtrees" (root.left, root.right). We only need to choose 
// the scenario which yields the larger amount of money.

// TC - 2^n because each time we hav two choices either to select that node or reject 
    
class Solution {
    public int rob(TreeNode root) {
        // Termination condtion for recursion 
        if(root == null)
            return 0;
        
        // case 1 : rob root node and its grandchildren
        int robCurrent = root.val;
        if(root.left != null)
            robCurrent += rob(root.left.left) + rob(root.left.right);
        
        if(root.right != null)
            robCurrent += rob(root.right.left) + rob(root.right.right);
        
        // case 2: rob childnodes only
        int doNotRobCurrent = 0;
        doNotRobCurrent += rob(root.left) + rob(root.right);
        
        // find the maxm amount you can get from both the cases
        return Math.max(robCurrent , doNotRobCurrent);
    }
}

// Step II -- Think one step further

// In step I, we only considered the aspect of "optimal substructure", but think little about the possibilities of overlapping of the subproblems.
// For example, to obtain rob(root), we need rob(root.left), rob(root.right), rob(root.left.left), rob(root.left.right), rob(root.right.left), 
// rob(root.right.right); but to get rob(root.left), we also need rob(root.left.left), rob(root.left.right), similarly for rob(root.right).
// The naive solution above computed these subproblems repeatedly, which resulted in bad time performance. Now if you recall the two conditions
// for dynamic programming (DP): "optimal substructure" + "overlapping of subproblems", we actually have a DP problem. A naive way to implement 
// DP here is to use a hash map to record the results for visited subtrees.

// The runtime is sharply reduced to 9 ms, at the expense of O(n) space cost (n is the total number of nodes; stack cost for recursion is not counted).
    
class Solution {
    
    HashMap<TreeNode,Integer> dp = new HashMap<>();
    
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        
        if(dp.containsKey(root))
            return dp.get(root);
        
        // case 1 : rob root node and its grandchildren
        int robCurrent = root.val;
        if(root.left != null)
            robCurrent += rob(root.left.left) + rob(root.left.right);
        
        if(root.right != null)
            robCurrent += rob(root.right.left) + rob(root.right.right);
        
        // case 2: rob childnodes only
        int doNotRobCurrent = 0;
        doNotRobCurrent += rob(root.left) + rob(root.right);
        
        // find the maxm amount you can get from both the cases
        // store result 
        int res =  Math.max(robCurrent , doNotRobCurrent);
        dp.put(root,res);
        return res;
    }
}
