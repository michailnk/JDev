package JavaOOP.Collection.alist.list;

public class AList {
    private Node head;
    private Node tail;
    private int size;


    public void push(Object item) {
        setSize(size++);
        Node node = new Node( );
        node.value = item;
        if (this.tail == null) {
            head = node;
            tail = node;
        } else {
            head.next = node;
            tail = node;
        }
    }

    public void printList() {
        Node curretn = head;
        while (curretn != null) {
            System.out.println(curretn.value);
            curretn = curretn.next;
        }
    }

    //region Prop
     void setHead(Node head) {
        this.head = head;
    }

     Node getHead() {
        return head;
    }

     Node getTail() {
        return tail;
    }

     void setTail(Node tail) {
        this.tail = tail;
    }

     int getSize() {
        return size;
    }

     void setSize(int size) {
        this.size = size;
    }
    // endregion
}
