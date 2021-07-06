
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode prev =null;
        while(node!=null){
            ListNode temp = node.next;
            if(node.val == val){
                if(prev!=null)
                     prev.next = temp;
                else
                    head = temp;
                node.next =null;
                node = prev;
            }
            prev= node;
            node = temp;
        }
        return head;
    }
}
