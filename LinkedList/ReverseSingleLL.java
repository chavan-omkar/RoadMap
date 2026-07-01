

public class ReverseSingleLL{

    private static class Node{
    int val;
     Node next;

    public Node() {
    }

    public Node(int val){
        this.val = val;
        this.next = null;
    }

    public Node(int val, Node node){
        this.val = val;
        this.next = node;
    }
}

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);

        Node n = reverse(node);

        print(n);
        
    }

    private static Node reverse(Node node){
        if(node == null){
            return node;
        }

        Node curr = node;
        Node prev = null;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void print(Node node){
        if(node == null){
            return;
        }

        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
    }


}



