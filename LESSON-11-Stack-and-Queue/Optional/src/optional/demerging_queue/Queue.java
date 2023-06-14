package optional.demerging_queue;

public class Queue {
    private Node head;
    private Node tail;

    private class Node {
        private Employee data;
        private Node next;

        public Node(Employee employee) {
            this.data = employee;
            this.next = null;
        }

        public Employee getData() {
            return data;
        }

        public void setData(Employee data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void enQueue(Employee employee) {
        Node temp = new Node(employee);
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }

    public String deQueue() {
        if (this.head == null) {
            return null;
        }
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        return temp.getData().getName() +
                ", " +
                temp.getData().getGender() +
                ", " +
                temp.getData().getDateOfBirth()[0] +
                "/" +
                temp.getData().getDateOfBirth()[1] +
                "/" +
                temp.getData().getDateOfBirth()[2] + "\n";
    }
}
