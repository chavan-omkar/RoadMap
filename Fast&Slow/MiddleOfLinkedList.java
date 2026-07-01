
public class MiddleOfLinkedList{
    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        print(findMiddleOfLL(head1));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);

        print(findMiddleOfLL(head2));


        ListNode head3 = new ListNode(1);
        print(findMiddleOfLL(head3));
        
    }

    private static void print(ListNode head){
        ListNode dummy = head;

        while(dummy != null){
            System.out.print(dummy.val + "->");
             dummy = dummy.next;
        }

        System.out.println();
       
    }


    private static ListNode findMiddleOfLL(ListNode head){
        if(head== null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}




class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;

    }

    public ListNode(int val,ListNode head){
        this.val = val;
        this.next = head;
    }
}