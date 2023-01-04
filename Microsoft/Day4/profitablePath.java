class Solution {
    // creating adjacency matrix
    Map<Integer , List<Integer>> tree = new HashMap<>();

    int[] parent = null;
    int[] dist = null;

    private void constructTree(int[][] edges){
        int n = edges.length;

        for(int i = 0; i < n; i++){ // checking every pair [ai , bi]

            int n1 = edges[i][0]; // ith row 0th col
            int n2 = edges[i][1]; // ith row 1st col

            if(!tree.containsKey(n1)){ // if n1 is not present in map
                tree.put(n1,new ArrayList<>()); // insert it into the map with a empty list
            }
            if(!tree.containsKey(n2)){ // same goes for n2 
                tree.put(n2,new ArrayList<>());
            }
            tree.get(n1).add(n2); // it is showing that n1 is connected with n2
            tree.get(n2).add(n1); // it is showing that n2 is connected with n1
        }
    }

    private void dfsToFindParent(int curr , int currParent , int currDist){
        dist[curr] = currDist;
        parent[curr] = currParent;

        for(Integer currNeighbour : tree.get(curr)){
            if(currNeighbour == currParent){ // if its visited skip it
                continue;
            }
            dfsToFindParent(currNeighbour , curr , currDist + 1); // call dfs for neighbours which are not visited yet
        }

    }

    Set<Integer> visited = new HashSet<>();
    int ans = 0;
    int maxAns = Integer.MIN_VALUE;

    private void dfs(int curr , int[] amount){
    visited.add(curr); // add it into the visitedSet
    ans = ans + amount[curr]; // calc currentProfit 
    int trav = 0; // TO detect the leaf node (already the neighbour nodes for leaf node are visited)
    for(Integer currNeighbour : tree.get(curr)){ // if neighbour is already visited skip it (check it in set)
        if(visited.contains(currNeighbour)){
            continue; 
        }
        trav++;
        dfs(currNeighbour,amount); // calling dfs for neighbours
    }
    if(trav == 0){ // reach the leaf node
       maxAns = Math.max(ans , maxAns); // calculate maxProfit
    }
    ans = ans - amount[curr]; // backtracking so that we can track other paths also 
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        constructTree(edges); // construct a adjacency matrix
        int n = edges.length;
        parent = new int[n + 1];
        dist = new int[n + 1];

        Arrays.fill(parent,-1);
        Arrays.fill(dist,-1);

        dfsToFindParent(0,0,0); // (curr , currParent , currdist)

        int curr = bob;   // from bob to when curr reach 0
        int currDist = 0;

        //update the parent and amount at each node 
        while(curr != 0){
            if(dist[curr] > currDist){ // if dist of currNode from root node is greater than currDist from bob's node
            // that means bob reaches first so alice is not concerned about this one at that particular time so amt[curr] = 0;
                amount[curr] = 0; 
            }
            else if(dist[curr] == currDist){ // if both reach at same node simulataneously than divide the amount by 2 
                amount[curr] /= 2;
            }
            curr = parent[curr]; // update curr with parent of curr
            currDist++; // inc curDist
        }
        //Now find the max sum you can obtain when you start moving from root node to any one of the leaf node (dfs)
        dfs(0,amount);

        return maxAns; // return the maximum profit 
    }
}
