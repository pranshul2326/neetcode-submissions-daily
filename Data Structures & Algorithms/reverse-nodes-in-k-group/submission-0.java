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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head, prev = null, nxt = null;
        ListNode temp = head;
        int counter = 0;
        while(counter<k && temp!=null){
            temp = temp.next;
            counter++;
        }
        if(counter<k){
            return head;
        }

        int cnt = k;
        while(cnt>0){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            cnt--;
        }
        head.next = reverseKGroup(curr, k);
        return prev;

    }
}
