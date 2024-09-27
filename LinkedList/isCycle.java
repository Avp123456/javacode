package LinkedList;

public class isCycle {
     // Node object -->i.e. linked list one node
     public static class Node{
        int data;
        Node next;  //refrence variable

        //constructor
        public  Node(int data){ 
            this.data = data;
            this.next = null;
        }
    }

    //define head and tail
    public static Node head;
    public static Node tail;

    
    public static boolean isCycleformed(Node head){
        if(head == null){
            return false;
        }
        Node slow=head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        head = new Node(1);
        head.next =  new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;
        System.out.println(isCycleformed(head)); 


    }
    
}
