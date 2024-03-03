
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
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
    }
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
    public static Node removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow == fast) {
            slow = head;
            if (slow == fast) {
                while (fast.next != slow) {
                    fast = fast.next;
                }
            } else {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
            }
            // fast.next = null;

        }
        return head;

    }
    public static Node addTwoLinkedlists(Node l1, Node l2) {
        Node temp1 = l1;
        Node temp2 = l2;
        int carry = 0;
        Node head = new Node(-1);
        Node newHead = head;
        while (temp1 != null || temp2 != null) {
            int sum = 0;
            if (temp1 != null) {
                sum += temp1.data;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                sum += temp2.data;
                temp2 = temp2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            newHead.next = newNode;
            newHead = newNode;
        }
        Node newNode = new Node(carry);
        if (carry != 0) {
            newHead.next = newNode;
        }
        return head.next;

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
    public static Node evenOddSeggregation(){
        Node evenHead = new Node(-1);
        Node oddHead = new Node(-1);
        Node even = evenHead;
        Node odd = oddHead;
        Node temp = head;
        int index = 0;
        while(temp!= null){
            if(index%2==0) {
                even.next = temp;
                even=even.next;
            }
            else {
                odd.next=temp;
                odd=odd.next;
            }
            index++;
            temp=temp.next;
        }
        even.next=oddHead.next;
        return evenHead.next;
    }
    public static Node sortColors(){
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two=twoHead;
        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }
            else{
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        two.next = null;
        if(oneHead.next == null){
            zero.next = twoHead.next;
        }
        else{
            zero.next = oneHead.next;
        }
        one.next = twoHead.next;
        return zeroHead.next;
    }
    public static boolean isPalindrom(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node prev=null;
        Node curr=slow;
        Node next;
        //isPalindrom();
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node temp=head;
        while(temp!=null&& prev!=null){
            if(temp.data != prev.data) return false;
            temp=temp.next;
            prev=prev.next;;
        }
        return true;
    }
    public static Node rotate(int k){
        Node temp=head;
        int count=0;
        while(temp.next!=null){
            count++;
            temp=temp.next;
        }
        count++;
        if(k%count==0) return head;
        k=k%count;
        temp.next=head;
        Node prev=null;
        for(int i=0;i<count-k+1;i++){
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
        head=temp;
        return head;
    }
    public static Node head2;
    public static int lenOfLL1(){
        Node temp = head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count++;
    }
    public static int lenOfLL2(){
        Node temp = head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count++;
    }
    public static void intersectionOfLL(){
        int len1=lenOfLL1();
        int len2=lenOfLL2();
        if(len1>len2){
            int steps=len1-len2;
            Node temp=head;
            while(steps!=0){
                head=head.next;
                steps--;
            }
        }
    }
    

    public static void main(String[] args) {
        // head=new Node(10);
        // head.next=new Node(20);
        // head.next.next=new Node(30);
        // head.next.next.next=new Node(40);
        // head.next.next.next.next=new Node(50);
        //head.next.next.next.next.next=new Node(10);
        // head=new Node(1);
        // head.next=new Node(0);
        // head.next.next=new Node(2);
        // head.next.next.next=new Node(0);
        // head.next.next.next.next=new Node(2);
        // head.next.next.next.next.next=new Node(1);
        // printLL(head);
        // System.out.println("Adding 100 at 1st");
        // addFirst(100);
        // printLL(head);
        // System.out.println("Adding 200 at middle");
        // addInMiddle(200,head);
        // printLL(head);
        // System.out.println("Adding 300 at 3rd position");
        // addAtCertainPos(300,3,head);
        // printLL(head);
        // System.out.println("Adding 400 at last");
        // addLast(400);
        // printLL(head);
        // System.out.println("count of all nodes:");
        // countNodes();
        // deleteFirst();
        // deleteLast();
        // deleteAtMiddle(head);
        // deleteAtCertainPos(head,3);
        // printLL(head);
        // search(head,300);
        // head=dltAtKPosFromLast(head,7);
        // printLL(head);
        // head = removeLoop(head);
        // printLL(head);
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(5);
        // printLL(l1);
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);
        l2.next.next.next = new Node(2);
        // printLL(l2);
        // head = addTwoLinkedlists(l1, l2);
        // printLL(head);
        // System.out.println("Reversing the linked list");
        // head=reverseOfLinkedList(head);
        // printLL(head);
        // System.out.println("even odd segregation:");
        // evenOddSeggregation();
        // printLL(head);
        // System.out.println("sorting the colours:");
        // head=sortColors();
        // printLL(head);
        //isPalindrom();
        // printLL(head);
        // System.out.println(isPalindrom());
        // rotate(3);
        // printLL(head);
        lenOfLL1();
        lenOfLL2();
        intersectionOfLL();
        printLL(head);
    }  
}
    
