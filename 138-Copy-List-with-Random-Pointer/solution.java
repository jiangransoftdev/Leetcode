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
        RandomListNode index=head;
        while(index!=null){
            RandomListNode dup=new RandomListNode(index.label);
            dup.next=index.next;
            index.next=dup;
            index=index.next.next;
        }
        index=head;
        while(index!=null){
            index.next.random=index.random==null?null:index.random.next;
            index=index.next.next;
        }
        index=head;
        RandomListNode dup=index==null?null:index.next;
        
        while(index!=null){
            RandomListNode tmp=index.next;
            index.next=tmp.next;
            if(tmp.next!=null)
                tmp.next=index.next.next;
            index=index.next;
        }
        return dup;
        
    }
}