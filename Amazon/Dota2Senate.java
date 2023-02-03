// This question is one of my favourite :)
// My leetcode post Link - https://leetcode.com/problems/dota2-senate/discuss/3135834/java-2-easy-approaches-cll-o-n-2-and-queues-o-n

// Approach 1 : Using Circular Singly Linked List
// The time complexity of this solution is O(n^2) where n is the length of the input string "senate". 
// This is because the "banOpponent" method iterates over the linked list to find the next non-banned node 
// with the opposite party, which has a time complexity of O(n). And this method is called repeatedly until 
// one of the parties is eliminated, which could happen at most n times, resulting in an overall time complexity of O(n^2).

class Node{
    char data;
    Node next;
    boolean banned;
    public Node(char data){
        this.data = data;
        banned = false;
    }
}

class Solution {
    Node head = null;
    Node tail = null;
    int radiant = 0;
    int dire = 0;
    public String predictPartyVictory(String senate) {
        for(char ch : senate.toCharArray()){
            addNode(ch);
            if(ch == 'R') radiant++;
            else dire++;
        }
        Node temp = head;
        while(radiant > 0 && dire > 0){
            if(temp.banned) { // if it is banned skip it 
                temp = temp.next; 
                continue; 
            }
            banOpponent(temp);
            if(temp.data == 'R') dire--;
            else radiant--;
            temp = temp.next;
        }
        return radiant > 0 ? "Radiant" : "Dire";
    }

    private void banOpponent(Node node) {
        Node cur = node.next;
        while(cur.data == node.data || cur.banned) cur = cur.next;
            cur.banned = true;
    }

    public void addNode(char value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = head;
    }
}

// Approach 2 : Using Queues
// The time complexity of this solution is O(N), where N is the number of senators in the senate string. This is because in the worst case,
// we will have to process every senator in the senate string once, which takes O(N) time.

class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();
        
        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                radiant.add(i);
            }else{
                dires.add(i);
            }
        }
        // 012 
        // RDD
        // radiant = [0] 
        // dires   = [1,2]
        // First D(0) & First R(1) is deleted or popped out 
        // but (0 < 1) that means we want to delete only the larger index so push back the smaller index
        // push again R which you have deleted previously but here is a catch push it back with the updated index for the next round
        // example : 
        // R D D
        // 0 1 2
        // 3 4 5
        // 6 7 8
        // 9 ..... so on 
        // radiant.add(0 + 3); i.e radiant.add(3);
        // radiant = [3]
        // dires   = [2]
        // index 1 is banned(X)
        // RXD
        // 3 2
        // delete both 
        // push back smaller again i.e iD
        // (2 < 3) so dires.add(3 + 3) = add(6) in dires queue
        // raidant = []
        // dires   = [6]
        // XXD, D is left at index 6 and radiant is empty now so and is "Dire".
        
        while(!radiant.isEmpty() && !dires.isEmpty()){
            int iR = radiant.poll();
            int iD = dires.poll();
            if(iR < iD){
                radiant.add(iR + n); 
                                  
            }else{
                dires.add(iD + n);
            }
            
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
