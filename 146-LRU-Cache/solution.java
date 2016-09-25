class Node{
    int key,val;
    Node prev,next;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        prev=null;
        next=null;
    }
}
public class LRUCache {
    int capacity,count;
    Map<Integer,Node> map=new HashMap<>();
    Node head,tail;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        count=0;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        head.prev=null;
        tail.prev=head;
        tail.next=null;
    }
    public void addNode(Node node){
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    public void deleteNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        int res=node.val;
        deleteNode(node);
        addNode(node);
        return res;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            deleteNode(node);
            addNode(node);
            
        }
        else{
            Node node=new Node(key,value);
            addNode(node);
            map.put(key,node);
            count++;
        }
        if(count>capacity){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
            count--;
        }
    }
}