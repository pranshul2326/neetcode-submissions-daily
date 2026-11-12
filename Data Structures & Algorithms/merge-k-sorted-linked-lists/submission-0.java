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
    public ListNode mergeKLists(ListNode[] lists) {
        int interval = 1;
        int k = lists.length;
        
        while(interval<k){
            int i =0 ;
            while(i+interval<k){
            lists[i] = mergeTwoList(lists[i], lists[interval+i]);
            i = i+interval*2;
            }
            interval = interval * 2;
        }

        return lists.length>0? lists[0]: null;
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(l1!=null && l2!=null){

            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;

            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
    }

        if(l1!=null){
            temp.next = l1;
        }else{
            temp.next = l2;
        }
        return dummy.next;
    }
}
