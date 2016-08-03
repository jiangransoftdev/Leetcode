class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}
public class LRUCache {
    Map<Integer,Node>map;
    int capacity,count;
    Node head,tail;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        count=0;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        head.prev=null;
        tail.next=null;
    }
    public void addToHead(Node node){
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;
    }
    public void delete(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            int result=node.value;
            delete(node);
            addToHead(node);
            return result;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            delete(node);
            addToHead(node);
        }
        else{
            Node node=new Node(key,value);
            map.put(key,node);
            if(count<capacity)
                count++;
            else{
                map.remove(tail.prev.key);
                delete(tail.prev);
            }
            addToHead(node);
        }
    }
}