
public class FlattenLL{

public static void main(String[] args) {
System.out.println("Hello World");
		int[] arr1 = {2, 3, 4, 5, 6};
        int[] arr2 = {8, 9, 10};
        int[] arr3 = {12};
        
       MultiLevelLLNode h1 = MultiLevelLLNode.buildMultiLevelLL(new MultiLevelLLNode(1), arr1);
       MultiLevelLLNode h2 = MultiLevelLLNode.buildMultiLevelLL(new MultiLevelLLNode(7), arr2);
       MultiLevelLLNode h3 = MultiLevelLLNode.buildMultiLevelLL(new MultiLevelLLNode(11), arr3);
       
       MultiLevelLLNode n3 = h1.next.next;
       n3.child = h2;
       
       
       MultiLevelLLNode n8 = h2.next;
       n8.child = h3;
       printLL(h1);
       MultiLevelLLNode node = flattenLL(h1);
       printLL(node);
	}
	
	private static void printLL(MultiLevelLLNode node){
	    MultiLevelLLNode n = node;
	    
	    while(n != null){
	        System.out.print(n.val + "->");
	        n = n.next;
	    }
	    System.out.println("null");
	}
	
	private static MultiLevelLLNode flattenLL(MultiLevelLLNode h1){
	    if(h1 == null) return null;
	    MultiLevelLLNode curr = h1;
	    MultiLevelLLNode tail = h1;
	    
	    while(tail.next != null){
	        
	        tail = tail.next;
	        
	    }
	    
	    while(curr != null){
	        if(curr.child != null){
	            tail.next = curr.child;
	            curr.child = null;
	            
	            while(tail.next != null){
	                tail = tail.next;
	            }
	        }
	        
	        curr = curr.next;
	    }
	    
	    return h1;
	}

}

class MultiLevelLLNode{
    int val;
    MultiLevelLLNode next;
    MultiLevelLLNode child;
    
    public MultiLevelLLNode(int val){
        this.val = val;
    }
    
    public MultiLevelLLNode(int val, MultiLevelLLNode next, MultiLevelLLNode child){
        this.val = val;
        this.next = next;
        this.child = child;
        
    }
    
    public static MultiLevelLLNode buildMultiLevelLL(MultiLevelLLNode node,int[] arr){
        MultiLevelLLNode curr = node;
        for(int a : arr){
            curr.next = new MultiLevelLLNode(a);
            curr = curr.next;
        }
        
        return node;
    }
}