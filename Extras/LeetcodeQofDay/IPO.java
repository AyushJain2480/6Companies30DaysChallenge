// GoldMan sachs
public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
       // sorted by minimum capital requirements
       // a and b are objects 
       // array = {capital , profit} a[0] and b[0] are capitals so we are sorting on the basis of capitals. 
       PriorityQueue<int[]> pqCap = new PriorityQueue<>((a,b) ->{
           return a[0] - b[0];
       });
        // sorted in decreasing order on the basis of max profits
       PriorityQueue<int[]> pqPro = new PriorityQueue<>((a,b) ->{
           return b[1] - a[1];
       });
        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[] {Capital[i], Profits[i]});
        }
        // pqCap = [{0,1},{1,2},{1,3}]
        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.add(pqCap.poll());
            }   
            if (pqPro.isEmpty()) break;
            
            W += pqPro.poll()[1];
        }
        return W;       
    }
}
