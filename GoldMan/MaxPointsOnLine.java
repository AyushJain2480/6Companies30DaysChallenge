class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n == 1) return 1;
       
        int max = 1; // global max atleast one point is on the line 

        for(int i = 0; i < n; i++){
         int[] a = points[i];
      
         Map<Double,Integer> map = new HashMap<>();
         int localMax = 1;
         
         for(int j = i + 1; j < n ; j++){
             double slope = getSlope(a,points[j]);
             map.put(slope , map.getOrDefault(slope , 1) + 1);
             int counts = map.get(slope);
             localMax = Math.max(localMax, counts);

         }
         max = Math.max(max,localMax);
        }
        return max;
    }

    private double getSlope(int[] a , int[] b){
        if(a[0] == b[0]) return Double.MAX_VALUE;
        if(a[1] == b[1]) return 0;
        return ((double) a[0] - b[0]) / ((double) a[1] - b[1]);
    }
}
