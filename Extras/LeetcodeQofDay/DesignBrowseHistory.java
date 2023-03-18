class BrowserHistory {
    Stack<String> history = new Stack<>();
    Stack<String> future = new Stack<>();
    
    public BrowserHistory(String homepage) {
        history.add(homepage); // push every incoming string in history and discard future.
        future.clear(); // reset as we can't go forward now 
    }
    
    public void visit(String url) {
        history.add(url);
        future.clear(); // reset as we can't go forward now
    }
    
    // backward means popping out from history and push it in future(as we might need it later)if we go forward
    public String back(int steps) {
        // minm 1 size history is required because at most we can reach the homepage 
        while(steps > 0 && history.size() > 1){
            future.add(history.pop());
            steps--;
        }
        return history.peek();
    }
    
    // forward means popping out from future and push it in history(as we might need it later)if we go back
    public String forward(int steps) {
        while(steps > 0 && future.size() > 0){
            history.add(future.pop());
            steps--;
        }
        return history.peek();
    }
}
