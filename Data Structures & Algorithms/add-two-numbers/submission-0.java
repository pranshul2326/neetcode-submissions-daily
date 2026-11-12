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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        ListNode i = l1;
        ListNode j = l2;
        int carr = 0;
        while(i!=null && j!=null){
            int a = i.val;
            int b = j.val;
            int sum = (carr+ (a+b))%10;
            carr = (carr+ (a+b))/10;
            ListNode node = new ListNode(sum);
            prev.next= node;
            prev = prev.next;
            i = i.next;
            j = j.next;
        }

        if(carr!=0){
            ListNode node = new ListNode(carr);
            prev.next= node;
            prev = prev.next;

        }

        return dummy.next;



        
    }
}
