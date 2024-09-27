//add--> first...atposition...last ,remove-first,print node , iterative search
package LinkedList;
public class LinkedList {

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
    public static int size;

    //Method to add the data in LL at FIRST Position
    public static void addFirst(int data){
        Node newNode = new Node(data);     //step 1 -->create new node
        size++;
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
        size++;
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

    public static void addAtPosition(int position,int data){
        if(position == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
       
        while(i < position-1){
            temp=temp.next;
            i++;
        }
        newNode.next =temp.next;
        temp.next = newNode;

    }

    public static void removeFirst(){
        if(size == 0){
            System.out.println("Linked List is empty");
        }else if(size == 1){
            head = tail =null;
            size = 0;
        }
        head = head.next;
        size--;
    }

    //iterative search
    public static int iterativeSearch(int key){
        Node temp =  head;
        int i = 0;
        while( temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;

        }
        return -1;
    } 
    // public static int helper(Node head, int key){
    //     if(head ==  null){
    //         return -1;
    //     }
    //     return 0;

    // }
    // public static int recursiveSearch(int key){

    // }


    public static void main(String[] args) {
        
        //add at first position of linked list
        addFirst(4);
        addFirst(3);
        addFirst(2);
        addFirst(1);

        //add at last position of linked list
        addLast(5);
        addLast(6);

        //add at specific position of linked list
       addAtPosition(3, 14);
        
        //print linked list
        print();

        //remove from first position
        removeFirst();
        print();

        //size of linked list
        System.out.println("Size of Linked List : "+size);

        //search a node
        System.out.println("Removed node from position : " + iterativeSearch(4));






    }
    
}
