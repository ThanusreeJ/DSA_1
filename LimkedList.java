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
    public static void countNodes(){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        System.out.println(count);
    }  
   public static void addLast(int data){
    Node temp = head;
    while(temp.next != null){
        temp = temp.next;
    }
    Node newNode = new Node(data);
    temp.next = newNode;
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
    public static void main(String[] args) {
        head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(50);
        printLL(head);
        addFirst(100);
        printLL(head);
        countNodes();
        addLast(200);
        printLL(head);
        deleteFirst();
        deleteLast();
        printLL(head);
        }  
}

