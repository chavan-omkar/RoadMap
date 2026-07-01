public class PalindromeLL{

    public static void main(String[] args) {

        int[] arr = {2,3,2,1};
        Node node = new Node(1);
        Node.buildLL(node, arr);
        System.out.println(isPalindrome(node));

        
    }


    private static boolean isPalindrome(Node node){
        Node mid = findMid(node);
        Node secondHead = reverse(mid);

        Node p1 = node;
        Node p2 = secondHead;

        boolean isPalindrome = true;

        while(p2 != null){

            if(p1.val != p2.val){
                isPalindrome = false;
                return isPalindrome;
            }

            p1 = p1.next;
            p2 = p2.next;

        }

        return isPalindrome;
    }

    private static Node findMid(Node node){
        Node slow = node;
        Node fast = node;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    private static Node reverse(Node node){
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


}


class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }

    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }

    public static void buildLL(Node node, int[] arr){
        for(int a : arr){
            node.next = new Node(a);
            node = node.next;
        }
    }
}