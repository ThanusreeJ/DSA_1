import java.util.*;
public class DoubleLL {
        static class Node{
            int data;
            Node next;
            Node prev;
            Node(int d) {
                data = d;
                next = null;
                prev = null;
            }
        }
        public static Node head;
        public static void printDLL(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"<->");
                temp=temp.next;
            }
            System.out.print("null");
        }
        public static void main(String[] args) {
            head=new Node(1);
            head.next=new Node(2);
            head.next.next=new Node(3);
            head.next.next.next=new Node(4);
            head.next.next.next.next=new Node(5);
            head.next.prev=head;
            head.next.next.prev=head.next;
            head.next.next.next.prev=head.next.next;
            head.next.next.next.next.prev=head.next.next.next;
            printDLL(); 
        } 
    }
