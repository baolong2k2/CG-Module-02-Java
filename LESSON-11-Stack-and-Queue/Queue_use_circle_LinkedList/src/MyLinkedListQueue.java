public class MyLinkedListQueue {
    private Node front;
    private Node rear;
    public void enqueue(int data) {
        Node temp = new Node(data);
        if(this.rear == null) {
            this.front=this.rear = temp;
            return;
        } else this.rear = temp;
        this.rear.next=this.front;
    }
    public Node dequeue() {
        if (this.rear == null)
            return null;
        Node temp = this.front;
        this.front = this.front.next;
        this.rear.next=this.front;
        if (this.front == null)
            this.rear = null;
        return temp;
    }
}
