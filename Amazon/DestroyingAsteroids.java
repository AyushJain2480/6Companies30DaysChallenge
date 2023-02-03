 // By sorting the asteroids in ascending order, we can ensure that the spacecraft will only encounter smaller asteroids first, and will only encounter larger asteroids if it has enough mass to destroy them.

//Intuition :

// Idea is to simply sort the asteroids list. & then we need to collide planet with asteroid.
// There are 2 cases :
// If planetMass >= asteroid, then we merge it. and continue

// else we planet get destroyed, and return false.

// In the end if all asteroids are collided, then return true
// This is basically a Greedy approach and we need to simulate the collision process.

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum = mass;
        for(int as : asteroids){
            if(as <= sum){
                sum += as;
            }else{
                return false;
            }
        }
        return true;
    }
}
