package LinkedList;

public class mergeSortInLL {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this .next= null;
        }
    }
    public static Node head;
    public static Node tail;

    public static Node midNode(Node head){
        Node slow = head ; 
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow =  slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node merge(Node head1 , Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 !=null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
            
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
            
        }
        return mergedLL.next;
    }

    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node mid = midNode(head);
        Node rightHead = mid.next;
        mid.next =null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft,newRight); 

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
        // mergeSortInLL ll = new mergeSortInLL();
        addFirst(2);
        addLast(3);
        addLast(1);
        addLast(5);
        print();
        head = mergeSort(head);
        print();



        
        
    }
    
}
