// For full Explanation of these solutions you can check my leetcode post 
// https://leetcode.com/problems/generate-random-point-in-a-circle/discuss/3145103/Javaor-Rejection-Sampling-and-polar-coordinate-or-Explained
// using rejection sampling method 
class Solution {
    double x0, y0, r;
    
    public Solution(double radius, double x_center, double y_center) {
        x0 = x_center; y0 = y_center; r = radius;
    }
    public double[] randPoint() {
         double x = -r + 2*r*Math.random();
         double y = -r + 2*r*Math.random();

        while (x * x + y * y > r * r) {
          x = -r + 2*r*Math.random();
          y = -r + 2*r*Math.random();
        }
        return new double[]{x0 + x , y0 + y};
    }
}

// using polar coordinates method
class Solution {
    double x0, y0, r;
    
    public Solution(double radius, double x_center, double y_center) {
        x0 = x_center; y0 = y_center; r = radius;
    }
    
    public double[] randPoint() {
        double deg = Math.random() * Math.PI * 2;
        double len = Math.sqrt(Math.random()) * r;
        return new double[]{x0 + len*Math.cos(deg), y0 + len*Math.sin(deg)};
    }
}
