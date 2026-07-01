
public class LinkedListIntersection{

    private static class Node{
        int val;
        Node next;

        public Node(){};
        public Node(int val){this.val = val;}
        public Node(int val,Node next){
            this.val = val;
            this.next =next;
        }
    }

    public static void main(String[] args) {

   Node common = new Node(8, new Node(7, new Node(2)));

        // Create List A: 1 -> 3 -> (connect to common)
        Node headA = new Node(1, new Node(3, new Node(4,common)));

        // Create List B: 6 -> (connect to common)
        Node headB = new Node(6, new Node(4,common));

        Node index = checkInterSection(headA,headB);

        if(index != null){
                System.out.println("Intersection point is : "+ index.val);
        }else{
            System.out.println("No Intersection");
        }

    }

    private static Node checkInterSection(Node a,Node b){

        Node headA = a;
        Node headB = b;

        while(headA != headB ){
            headA = (headA == null) ? b : headA.next;
            headB = (headB == null) ? a : headB.next;
        }

        return headA;

    }

}