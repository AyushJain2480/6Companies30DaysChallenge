class Solution {
   StringBuilder str = new StringBuilder(); // rep as {}
   HashMap<Long, Integer> map = new HashMap<Long, Integer>(); // rep as []
  
  public String fractionToDecimal(int numerator, int denominator) {
    if (denominator == 0) return ""; // exception
    if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
        str.append('-'); // -ve/+ve or +ve/-ve == -ve so add -ve sign
    }
    long num = Math.abs((long)numerator); // num = 1
    long den = Math.abs((long)denominator); // den = 10
    long val = num/den; // val = 0
    long rem = num % den; // rem = 1
    str.append(val); // {"0"}
    if (rem == 0) return str.toString(); // if there is no fractional part
    else str.append('.'); // {"0.} // if there is fractional part
    return appendFraction(rem , val , den);
}
  public String appendFraction(long rem, long val, long den){
    // run the while loop until the rem gets repeated or break it when rem = 0  
    while(!map.containsKey(rem)) {
        map.put(rem,str.length()); // [1 , 2] map = {rem,length} str = {"0."}
        long num = rem * 10; // { 10) 1 (0. } --> { 10) 1*10 (0.1 }
        val = num / den; // val = 10 / 10 = 1
        rem = num % den; // rem = 10 % 10 = 0
        str.append(val); // {"0."} --> {"0.1"}
        if(rem == 0){ // means there is no repeatition so return the string
            return str.toString(); // rem = 0 return --> {"0.1"} non repeatable
        }
    }
    // (rem != 0) means it is repeating so add ( at position from where it starts repeating
    str.insert(map.get(rem),"(");
    str.append(')'); // add ) where repeation ends           
    return str.toString();
  }
}
