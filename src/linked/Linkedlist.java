package linked;

public class Linkedlist {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next=head;
        head=newNode;
    }
}


