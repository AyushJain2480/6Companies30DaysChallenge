class WordDictionary {
    Map<Integer, List<String>> map = new HashMap<>();
    
    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        int len = word.length();
        map.putIfAbsent(len, new ArrayList<>());
        map.get(len).add(word);
    }
    
     public boolean search(String word) {
        List<String> list = map.get(word.length());
        if (list == null) {
            return false;
        }
        for (String s : list) {
            if (isMatch(s, word)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isMatch(String s, String p) {
        for (int i = 0; i < s.length(); i++) {
            if (p.charAt(i) != '.' && s.charAt(i) != p.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
