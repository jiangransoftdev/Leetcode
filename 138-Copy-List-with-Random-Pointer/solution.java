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
            RandomListNode copy=new RandomListNode(index.label);
            copy.next=index.next;
            index.next=copy;
            index=index.next.next;
        }
        index=head;
        while(index!=null){
            index.next.random=index.random==null?null:index.random.next;
            index=index.next.next;
        }
        index=head;
        RandomListNode dup=index.next;
        while(index!=null){
            RandomListNode tmp=index.next.next;
            if(tmp!=null)
                index.next.next=tmp.next;
            index.next=tmp;
            index=tmp;
        }
        return dup;
    }
}