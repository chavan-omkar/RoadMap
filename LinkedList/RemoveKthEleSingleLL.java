
public class RemoveKthEleSingleLL{

    private static class Node{
        int val;
        Node next;

        public Node(){

        }

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node node){
            this.val = val;
            this.next = node;
        }
    }

    public static void main(String[] args) {
        Node start = new Node(1);
        int[] arr = new int[]{1,2,3,4,5,6};
       Node head = buildLL(arr);
       int r = 2;
       removeKthLastElement(head,r);
       print(head);
        
    }

    private static Node removeKthLastElement(Node node, int r){
        Node dummy = new Node(0,node);
        Node slow = dummy;
        Node fast = dummy;

        for(int i =0;i<=r;i++){
            if(fast == null) return node;
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        if(slow.next != null){
            slow.next = slow.next.next;
        }
       
        return dummy.next;
    }

    private static void print(Node head){
        if(head == null) return;
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }

    private static Node buildLL(int[] arr){
        if(arr == null || arr.length ==0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for(int i = 1;i<arr.length;i++){
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }

            return head;
    }
}