class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode start = head;
        while(start != null){
            int sum = 0;
            ListNode temp = start; 
            while(temp != null){
                sum += temp.val;
                if(sum == 0){
                    if(start == head){
                        start = temp.next;
                        head = start;
                        break;
                    }
                    ListNode can = head;
                    while(can.next != start){
                        can = can.next;
                    }
                    start = temp.next;
                    can.next = start;
                    break;
                }
                temp = temp.next;
            }
           if(sum != 0) 
           start = start.next;
        }
        return head;
    }  
}
