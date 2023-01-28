// BELOW IS NAIVE APPROACH [TLE] 🫡

// Here we travel from bottom to top and go on checking wether we can add that particular floor, else we reset to 0.
class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int floors = 0, currentMax = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int specialFloor : special) set.add(specialFloor);
        
        for(int floor = bottom; floor <= top; floor++){
            if(!set.contains(floor)) {
                currentMax++;
                floors = Math.max(floors, currentMax);
            } else 
                currentMax = 0;
        }
        
        return floors;
    }
}


// BELOW IS OPTIMZED VERSION

// Here we sort the floors and go special floor to special floor.
// Once it is done we have to check bottom to first special floor and top to last special floor.
class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int floors = 0, n = special.length;
        Arrays.sort(special);
        
        for(int i = 0; i < n - 1; i++)
            floors = Math.max(floors, special[i + 1] - special[i] - 1);
        
        floors = Math.max(floors, Math.max( special[0] - bottom, top - special[n - 1]));
        
        return floors;
    }
}
