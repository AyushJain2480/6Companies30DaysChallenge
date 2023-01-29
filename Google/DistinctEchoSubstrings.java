class Solution {
public static int distinctEchoSubstrings(String text) {
    
    Set<String> s = new HashSet<>();
    
    for (int i = 0; i < text.length(); i++)
        
    for (int j = i + 1; j < text.length(); j++)
        
    if (text.charAt(i) == text.charAt(j) && j + j - i <= text.length())
        
    if (text.substring(i, j).equals(text.substring(j, j + j - i)))
        
    s.add(text.substring(i, j) + text.substring(j, j + j - i));
    
    return s.size();
    
}
}
