/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        // ListNode curr = head, prev = null, next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        return prev;

    }
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        ListNode s = head, f = head;
        while(f.next != null && f.next.next != null){ // f.next.next!=null && f.next!=null 
            s = s.next;
            f = f.next.next;
        }
        // ListNode mid = s.next;

        // reverse(mid);

        ListNode mid = s.next;
        s.next = null;
        mid = reverse(mid);

        // ListNode temp = head;
        // ListNode dummy = new ListNode(-1);
        // dummy = temp;
        // boolean first = true;

        ListNode first = head;
        ListNode second = mid;


        while(second!=null){
                ListNode firstNext = first.next;
                ListNode secondNext = second.next;

                first.next = second;
                second.next = firstNext;

                first = firstNext;
                second = secondNext;
        }
        // temp = head==null? mid:head;
        // head = dummy.next;
        
    }
}
