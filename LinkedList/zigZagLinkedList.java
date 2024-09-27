package LinkedList;

public class zigZagLinkedList {
    
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
    public static void zigZag(){
        //fint mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow =  slow.next; 
        }
        Node midN = slow;
        //reverse after mid
        Node midNext = midN.next;
        midN.next = null;
        Node prev = null;
        Node next;
        while (midNext != null) {
            next = midNext.next;
            midNext.next = prev;
            prev = midNext;
            midNext = next;   
        }
        //alternate merge i.e zig-zag merge
        Node left = head;
        Node right = prev;
        Node nextL,nextR;

        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;


        }
    }

      //Method to add the data in LL at FIRST Position
      public static void addFirst(int data){
        Node newNode = new Node(data);     //step 1 -->create new node
      
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;              //step 2 --> newNode ka next =head
        head = newNode;                  //step 3 --> head = newNode

    }

        //Method to add the data in LL at Last Position
    public static void addLast(int data){
        Node newNode = new Node(data); //step 1 -->create new node
        
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;     //step 2 --> tail ka next = newNode
        tail= newNode;          //step 3 --> tail = newNode
    }

    //Method to PRINT the data in LL
    public static void print(){
        Node  temp = head;
        if(head == null){
            System.out.println(" Linked List is Empty");
            return;
        }
        while(temp != null){
            System.out.print(temp.data +" -> "); //print the data
            temp = temp.next;       //go to next node
        } 
        System.out.println("null");
    }
    public static void main(String[] args) {
        addFirst(2);
        addLast(3);
        addLast(1);
        addLast(5);
        addLast(6);
        addLast(7);
        addLast(8);


        print();
        zigZag();
        print();
    }
    
}
