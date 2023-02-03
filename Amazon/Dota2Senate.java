// The time complexity of this solution is O(n^2) where n is the length of the input string "senate". 
// This is because the "banOpponent" method iterates over the linked list to find the next non-banned node with the opposite party, 
// which has a time complexity of O(n). And this method is called repeatedly until one of the parties is eliminated, which could happen
// at most n times, resulting in an overall time complexity of O(n^2).

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
