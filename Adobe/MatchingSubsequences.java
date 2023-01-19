 // This one is brute force of brute force because generating all subsequences and than checking all the word takes a hell of time.
 // But its important to know the brute force also , By using backtracking here we have two choices here for generating all subsequences. 
 // At each step we have two choices either select a char or not select it. (give TLE)
class Solution { 
    Set<String> set = new HashSet<>();
    int count = 0;
    public int numMatchingSubseq(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        printSubsequences(sb, s, 0);
        for(String word : words){
            if(set.contains(word)){
                count++;
            }
        }
        return count;
    }

    
    void printSubsequences(StringBuilder sb, String str, int index) {
        if (index == str.length()) {
            set.add(sb.toString());
            return;
        }
        printSubsequences(sb.append(str.charAt(index)) , str , index + 1);
        sb.deleteCharAt(sb.length()-1);
        printSubsequences(sb, str, index+1);
    }
}

// 
