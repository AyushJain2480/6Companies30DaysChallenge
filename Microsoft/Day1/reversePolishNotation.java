// The basic approach for the problem is using the stack.

// Accessing all elements in the array, if the element is not matching with the special character (‘+’, ‘-‘,’*’, ‘/’) then push the element to the stack.
// Then whenever the special character is found then pop the first two-element from the stack and perform the action and then push the element to stack again.
// Repeat the above two process to all elements in the array
// At last pop the element from the stack and print the Result

// TC - O(N)
// SC - O(N)

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        int pans = 0;
        Stack<String> stack = new Stack<String>();
        int i = 0;
        while(i < tokens.length){  
            do{
                stack.push(tokens[i++]);
            }while(!stack.peek().equals("-") && !stack.peek().equals("+") && !stack.peek().equals("*") && !stack.peek().equals("/"));

           String opr = stack.pop();
           String ele2 = stack.pop();
           String ele1 = stack.pop();

           pans = operation(opr,ele1,ele2);

           stack.push(Integer.toString(pans));

        }
        return pans;
    }

    private int operation(String opr , String ele1 , String ele2){
        int ans = 0;
        if(opr.equals("+")){
            ans = Integer.parseInt(ele1) + Integer.parseInt(ele2);
        }
        else if(opr.equals("-")){
            ans = Integer.parseInt(ele1) - Integer.parseInt(ele2);
        }
        else if(opr.equals("*")){
            ans = Integer.parseInt(ele1) * Integer.parseInt(ele2);
        }
        else if(opr.equals("/")){
            ans = Integer.parseInt(ele1) / Integer.parseInt(ele2);
        }
        return ans;
    }
}
