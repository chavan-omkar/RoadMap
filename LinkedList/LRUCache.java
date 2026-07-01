import java.util.*;
public class LRUCache{ 
public static void main(String[] args) {
LRU cache = new LRU(3);
cache.put(1, 100);
  cache.put(2, 250);
  cache.get(2);
  cache.put(4, 300);
  cache.put(3, 200);
  cache.get(4);
  cache.get(1);

System.out.println("Value for key 1: " + cache.get(1)); // Should be -1
        System.out.println("Value for key 2: " + cache.get(2));
    
    
}


}

class LRU{
    private int capacity;
    private Map<Integer,Node> map;
    Node head;
    Node tail;

    public LRU(int capacity){
        this.capacity = capacity;
        map = new HashMap<>(this.capacity);
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public static class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }

    }


    public Integer get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int val){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node node = new Node(key,val);
        insert(node);
        map.put(key, node);
        if(map.size() > this.capacity){
            Node removeNode = head.next;
            map.remove(removeNode.key);
            remove(removeNode);
        }
    
    }

    private void insert(Node node){

        Node curr = tail.prev;
        node.prev = curr;
        curr.next = node;
        node.next = tail;
        tail.prev = node;

        
    }


}