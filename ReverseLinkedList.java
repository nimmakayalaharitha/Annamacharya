class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next; 
            current.next = prev;              
            prev = current;                 
            current = nextNode;              
        }
        return prev;
    }
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();

        // Creating a simple list: 1 -> 2 -> 3 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println("Original List:");
        list.printList(head);

        ListNode reversedHead = list.reverseList(head);

        System.out.println("Reversed List:");
        list.printList(reversedHead);
    }
}
