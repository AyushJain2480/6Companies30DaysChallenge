// backtracking approach - generating all subsequences
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

// a better brute force  - TLE
class Solution {
    int count = 0;
    public int numMatchingSubseq(String s, String[] words) {
        for(String word : words){
            if(isSubsequence(word, s)){
                count++;
            }
        }
       return count;
    }  
     public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int j = 0;
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == s.charAt(j)){
                j++;
            }
            if(j >= s.length()) return true;
        }
        return false;
    }
}
