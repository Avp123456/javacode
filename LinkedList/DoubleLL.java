package LinkedList;

public class DoubleLL {
     // Node object -->i.e. linked list one node
     public static class Node{
        int data;
        Node next;  //refrence variable
        Node prev;

        //constructor
        public  Node(int data){ 
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }

    //define head and tail
    public static Node head;
    public static Node tail;

    public static void addFirst(int data){
        Node newNode =  new Node (data);
        if(head == null){
            head =  tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }
    public static void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+ " <-> "); 
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void remove(){
        if(head == null){
            System.out.println("list is already empty");
            return;
        }
        head = head.next;
        head.prev =null;

    }
    public static void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;

    }
    public static void main(String[] args) {
        addFirst(1);
        addFirst(2);
        addFirst(3);
        addFirst(4);
        print();
        remove();
        print();
        reverse();
        print();

        
    }
    
}
