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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sHead = new ListNode(),sTail = sHead,rHead = null, rTail = null, node = head;
        int i= 0; 
        
        while(node!= null){//Still have nodes to process
            //Storing next node before doing any operation
            ListNode next = node.next;
            //disconnecting current node
            node.next = null;
            i++;
            
            if(i<left || i> right){//not in the range where we want to reverse
                sTail.next = node;
                sTail = node;
            } 
            else{//in the range
                
//The first node in the range we encounter will become tail of the reversed list
                if(rTail == null)
                    rTail = node;
                 
                //making the current node head of the reversed linkedList
                node.next = rHead;
                rHead = node;
                //if This is the last node of the reverse linked list
                if(i+1> right){
            //making the node before the reversed list point to the head of reversed node    
                    sTail.next = rHead;
                    //Setting stail = rtail so that in next iteration we append as usual 
                    sTail = rTail;
                }
            }
            node = next;
        }
        return sHead.next;
    }
}
