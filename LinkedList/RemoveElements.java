
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
        //previous node initially null
        ListNode prev =null;
        while(node!=null){
            //Storing next node 
            ListNode temp = node.next;
            if(node.val == val){
                //prev is not null i.e. element to remove is not at head
                if(prev!=null)
                     prev.next = temp;
                //element to remove is at head so move head forward
                else
                    head = temp;
                //disconnect the node to delete
                node.next =null;
                //now the node is pointing to the previous node
                node = prev;
            } 
            //if no changes were made prev will point to next node 
            //if any node was deleted prev will point to itself as we have changed node to prev
            prev= node;
            //moving node forward using the next node we stored earlier
            node = temp;
        }
        return head;
    }
}
