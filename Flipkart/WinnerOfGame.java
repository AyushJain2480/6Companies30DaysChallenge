class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}
class Solution {
    Node head = null;
    Node tail = null;
    
    public void addNode(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = head;   
    }
    
    public int findTheWinner(int n, int k) {
        for(int i = 1; i <= n; i++){
            addNode(i);
        }
        Node temp = head;
        while(true){
            if(head.next == head){
                return head.data;
            }
            int count = 1;
            while(count < k){
                temp = temp.next;
                count++;
            }
            Node deleteNode = temp;
            temp = temp.next;
            remove(deleteNode);
        }  
    }
    
    public void remove(Node temp){
        if(temp == head){
           head = head.next;
           tail.next = head; 
        }
        else{
            Node prev = head;
            while(prev.next != temp){
                prev = prev.next;
            }
            prev.next = temp.next;
            if(temp == tail)
                tail = prev;
        }
    }
}
