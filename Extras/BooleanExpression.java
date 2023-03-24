// Both Deque<Character> and Stack<Character> can be used to implement the stack data structure in Java.
// However, it is recommended to use Deque instead of Stack because Stack is an old class and its methods are synchronized,
// which can result in slower performance compared to Deque.

// In terms of performance, Deque is generally faster than Stack. This is because Deque is implemented as a double-ended queue
// , which allows for efficient insertion and removal of elements at both ends. In contrast, Stack is implemented as a vector 
// and is synchronized, which can lead to slower performance.

// Therefore, it is better to use Deque instead of Stack for implementing a stack in Java.
class Solution { 
     public boolean parseBoolExpr(String e) {
         
        // Both are using LIFO 
        Deque<Character> s = new LinkedList<>();
        // Stack<Character> s = new Stack<>();
            
        for(char c : e.toCharArray()) {
            if(c == ')') {
                Set<Character> seen = new HashSet<>();
                while(s.peek() != '(') seen.add(s.pop());
                s.pop();
                char op = s.pop();
                if(op == '&') {
                    s.push(seen.contains('f') ? 'f' : 't');
                } else if(op == '|') {
                    s.push(seen.contains('t') ? 't' : 'f');
                } else if(op == '!') {
                    s.push(seen.contains('f') ? 't' : 'f');
                }
            } else if(c != ',') {
                s.push(c);
            }
        }
        return s.peek() == 't' ? true : false;
    }
}
