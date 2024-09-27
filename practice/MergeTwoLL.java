import java.util.*;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeTwoLL {
    public static Node mergeTwoLists(Node head1, Node head2) {
        Node newNode = new Node(0); // Dummy node to simplify merging
        Node current = newNode; // Use current to build the new list

        // Merge the two lists
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next; // Move to the next position in the new list
        }

        // Append any remaining nodes from either list
        if (head1 != null) {
            current.next = head1; // Append the rest of list1
        }
        if (head2 != null) {
            current.next = head2; // Append the rest of list2
        }

        return newNode.next; // Return the merged list starting from the next node of dummy
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(4);

        // Manually create ~list2 = [1, 3, 4]
        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node mergedList = mergeTwoLists(list1, list2);

        // Print the merged list
        printList(mergedList); // Expected Output: 1 1 2 3 4 4
    }
}
