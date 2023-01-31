// backtracking solution 
class Solution {
    
    public List<String> restoreIpAddresses(String s) {
       List<String> list = new LinkedList<>();
       helper(s, 0, 4, new StringBuilder() , list);
       return list; 
    }
    
    public void helper(String s, int pos, int step , StringBuilder sb, List<String> list){
        
        if(step < 0) return;
        
        if(step == 0 && pos == s.length()){
            list.add(sb.toString().substring(0,sb.length() - 1));
            return;
        }
        
        for(int i = pos; i < pos + 3 && i < s.length(); i++){
            String num = s.substring(pos , i + 1);
            if(!isValid(num)) continue;
            
            sb.append(num).append(".");
            helper(s, i + 1, step - 1, sb , list);
            sb.setLength(sb.length() - (i - pos + 1 + 1)); // backtrack remove num.
        }
        
    }
    
    public boolean isValid(String s){
        if(Integer.parseInt(s) > 255 || (s.startsWith("0") && s.length() > 1)){
            return false;
        }else{
            return true;
        }
    }
}
