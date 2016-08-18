/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode cur=head;
        while(cur!=null){
            RandomListNode copy=new RandomListNode(cur.label);
            copy.next=cur.next;
            cur.next=copy;
            cur=cur.next.next;
        }
        cur=head;
        while(cur!=null){
            cur.next.random=cur.random==null?null:cur.random.next;
            cur=cur.next.next;
        }
        cur=head;
        RandomListNode dup=cur==null?null:cur.next;
        while(cur!=null){
            RandomListNode tmp=cur.next;
            cur.next=tmp.next;
            if(tmp.next!=null)
                tmp.next=tmp.next.next;
            cur=cur.next;
        }
        return dup;
        
        
    }
}