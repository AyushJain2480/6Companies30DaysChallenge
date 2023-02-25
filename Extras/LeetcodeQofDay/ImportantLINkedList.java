// One possible issue in this approach is that the String concatenation operation s += temp.val in the while  
// loop of isPalindrome is inefficient for large input sizes because it creates a new string in every iteration.
// This can be improved by using a StringBuilder instead of a String.
class Solution {
    public boolean isPalindrome(ListNode head) {
       StringBuilder sb = new StringBuilder();
       ListNode temp = head;
       while(temp != null){
           sb.append(temp.val);
           temp = temp.next;
       } 
       return isPal(sb); 
    }
    
    public boolean isPal(StringBuilder sb){
    int left = 0;
    int right = sb.length() - 1;
    while (left < right) {
        if (sb.charAt(left) != sb.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
}

//This code uses two pointers, slow and fast, to find the middle of the linked list. Once the middle is found, the second half
// of the linked list is reversed using the reverseList method. Then, two pointers p1 and p2 are used to compare the values of the
// nodes in the first half of the linked list and the reversed second half of the linked list. If any of the nodes do not match,
// the method returns false. Otherwise, the method returns true.
// This approach has a time complexity of O(n) and a space complexity of O(1), which is the optimal solution for this problem.

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        } 
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        // Find the middle of the list using slow and fast pointers
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Reverse the second half of the list
        ListNode revHead = reverseList(slow.next);
        slow.next = null;
        
        // Compare the first half of the list with the reversed second half
        ListNode p1 = head;
        ListNode p2 = revHead;
        while(p1 != null && p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
    }
    
    // Helper function to reverse a linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
