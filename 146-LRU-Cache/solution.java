class ListNode{
    int key,value;
    ListNode next;
    ListNode prev;
    public ListNode(int key,int value){
        this.key=key;
        this.value=value;
    }
}
public class LRUCache {
    Map<Integer,ListNode> map;
    ListNode head,tail;
    int capacity;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        head=new ListNode(0,0);
        tail=new ListNode(0,0);
        head.next=tail;
        head.prev=null;
        tail.next=null;
        tail.prev=head;
        this.capacity=capacity;
    }
    public void deleteNode(ListNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void addNode(ListNode node){
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode cur=map.get(key);
        deleteNode(cur);
        addNode(cur);
        return cur.value;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            ListNode node=map.get(key);
            node.value=value;
            deleteNode(node);
            addNode(node);
        }
        else{
            ListNode node=new ListNode(key,value);
            addNode(node);
            map.put(key,node);
            if(map.size()>capacity){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
            } 
        }
    }
    
}