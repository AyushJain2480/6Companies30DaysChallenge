// a = "11" = "3"
// b =  "1" = "1"
// sum = a + b = "4" = "100"
//By passing a and 2 to the BigInteger constructor, the binary representation of a is converted into a BigInteger object, which can then be used to perform arithmetic operations such as addition, subtraction, multiplication, and division.
import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
       // num1 <-- ("11", 2)
       // num1 --> [3] 
       BigInteger num1 = new BigInteger(a, 2);
        
       // num2 <-- ("1", 2)
       // num2 --> [1] 
       BigInteger num2 = new BigInteger(b, 2); 
        
       // sum --> [4] 
       BigInteger sum = num1.add(num2); 
        
       // represents the binary value of the 'BigInteger' object 'sum' -> "100"
       return sum.toString(2); 
    }
    
}
