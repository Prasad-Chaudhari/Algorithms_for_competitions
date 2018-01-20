class Node {

    int data;
    Node next;

    public Node(int a) {
        this.data = a;
    }
}

class LinkedList2 {

    Node head;
    Node tail;
    int length;

    public LinkedList2() {
        head = null;
        tail = null;
        length = 0;
    }

    public void add(int a) {
        if (head == null) {
            head = new Node(a);
            tail = head;
            length++;
        } else {
            Node curr = new Node(a);
            tail.next = curr;
            length++;
            tail = curr;
        }
    }

    public void addAll(LinkedList2 a) {
        if (length == 0) {
            head = a.head;
            tail = a.tail;
            length = a.length;
        } else if (a.length != 0) {
            tail.next = a.head;
            tail = a.tail;
            length += a.length;
        }
    }

    public int removeFirst() {
        if (head != null) {
            int i = head.data;
            if (head.next == null) {
                tail = null;
            }
            head = head.next;
            length--;
            return i;
        } else {
            return -1;
        }
    }

    public int size() {
        return length;
    }

    public void clear() {
        head = null;
        tail = null;
    }
}