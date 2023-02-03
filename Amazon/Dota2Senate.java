// Its really hard to solve this problem by using circular singly linked list it's not the best approach but it's accepted :)
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
