
public class LimkedList {
    static class Node{
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static Node head;
    public static void printLL(Node head) {
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");    
    }
    public static void addFirst(int data){
       Node newNode = new Node(data);
       newNode.next=head;
       head = newNode;
    }
    public static Node addInMiddle(int data, Node head) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node slow = head;
            Node fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            Node newNode = new Node(data);
            newNode.next = slow.next;
            slow.next = newNode;
        }
        return head;
    }
    public static Node addAtCertainPos(int data, int pos, Node head) {
        Node temp = head;
        if (head == null) {
            head = new Node(data);
        } else {

            int count = 1;
            while (count != pos - 1) {
                count = count + 1;
                temp = temp.next;
            }
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    public static void addLast(int data){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
       }
    public static void countNodes(){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        System.out.println(count);
    }  
   public static void deleteFirst(){
    head = head.next;
    }
    public static void deleteLast() {
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;    
    }
    public static Node deleteAtMiddle(Node head) {
        Node temp = head;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            // slow = slow.next;
            fast = fast.next.next;
            slow = slow.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    public static Node deleteAtCertainPos(Node head, int pos) {
        Node temp = head;
        int count = 1;
        while (count != pos - 1) {
            count = count + 1;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    public static boolean search(Node head, int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data)
                return true;
            temp = temp.next;
        }
        return false;
    }
    public static Node dltAtKPosFromLast(Node head, int K) {
        Node fast = head;
        while (K != 0 && fast != null) {
            fast = fast.next;
            K--;
        }
        if (K != 0) {
            return head;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }
        Node slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static Node reverseOfLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(50);
        head.next.next.next.next.next=new Node(60);
        printLL(head);
        addFirst(100);
        printLL(head);
        addInMiddle(200,head);
        printLL(head);
        addAtCertainPos(300,3,head);
        printLL(head);
        addLast(400);
        printLL(head);
        countNodes();
        deleteFirst();
        deleteLast();
        deleteAtMiddle(head);
        deleteAtCertainPos(head,3);
        printLL(head);
        search(head,300);
        dltAtKPosFromLast(head,1);
        printLL(head);
        reverseOfLinkedList(head);
        printLL(head);
    }  
}
    