

public class PalindromeChecker {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    //fuction to find the middle node:-
    public Node midNode(Node head){
        Node slow=head;
        Node fast=head;
        while (fast !=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    //to check the palindrome of the linked list :-
    public boolean CheckPalindrome(){

        // base case 
        if(head == null || head.next  ==null){
            return true;
        }

        // step1 :- find middle node
        Node Middle = midNode(head);

        // step2:- reverse the 2nd part 
        Node curr = Middle;
        Node prev = null;
        Node nxt;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        Node right = prev;
        Node left = head;

        // step3:- check left == right;
        while (right!=null) {
            if (right.data != left.data) {
                return false;
            }
            right = right.next;
            left = left.next;
            
        }
        return true;
    }


    public void Reversell() {
        Node curr = tail = head;
        Node prev = null;
        Node nxt;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head = prev;
    }

    public static void main(String[] args) {
        PalindromeChecker lr = new PalindromeChecker();
        lr.addFirst(1);
        lr.addFirst(2);
        lr.addFirst(1);
        lr.addFirst(2);    
        System.out.println(lr.CheckPalindrome());
    }
}