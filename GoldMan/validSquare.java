class Solution {
    // !set.contains(0) avoid duplicates 
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(dist(p1,p2));
        set.add(dist(p1,p3));
        set.add(dist(p1,p4));
        set.add(dist(p2,p3));
        set.add(dist(p2,p4));
        set.add(dist(p3,p4));
        
        return set.size() == 2 && !set.contains(0); 
    }
    
    public int dist(int[] p, int[] q){
        return (q[0]-p[0])*(q[0]-p[0]) + (q[1]-p[1])*(q[1]-p[1]);
    }

}
