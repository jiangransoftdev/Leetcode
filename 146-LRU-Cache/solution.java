class ListNode{
    int value;
    int key;
    ListNode prev;
    ListNode next;
    public ListNode(int key,int value){
        this.key=key;
        this.value=value;
    }
}
public class LRUCache {
    ListNode head,tail;
    int count,capacity;
    Map<Integer,ListNode> map;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        head=new ListNode(0,0);
        tail=new ListNode(0,0);
        count=0;
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
        head.prev=null;
        tail.next=null;
    }
    public void addNode(ListNode node){
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    public void delete(ListNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node=map.get(key);
            delete(node);
            addNode(node);
            return node.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            ListNode node=map.get(key);
            node.value=value;
            delete(node);
            addNode(node);
        }
        else{
            ListNode node=new ListNode(key,value);
            map.put(key,node);
            if(count<capacity)
                count++;
            else{
                map.remove(tail.prev.key);
                delete(tail.prev);
            }
            addNode(node);
        }
    }
}