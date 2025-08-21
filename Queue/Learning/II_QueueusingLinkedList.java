package Learning;

public class II_QueueusingLinkedList {
    class QueueNode {
        int data;
        QueueNode next;

        QueueNode(int d) {
            data = d;
            next = null;
        }
    }

    QueueNode front;
    QueueNode rear;
    int size;

    II_QueueusingLinkedList() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(int x) {
        QueueNode newNode = new QueueNode(x);
        if (front == null) {
            front = newNode;
            rear = front;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (front == null) return -1;
        int data = front.data;
        front = front.next;
        if (front == null) rear = null; // Queue became empty
        size--;
        return data;
    }

    public int queueSize() {
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void printQueue() {
        QueueNode current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        II_QueueusingLinkedList q = new II_QueueusingLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printQueue();
        System.out.println("Element dequeued: " + q.dequeue());
        System.out.println("Queue size: " + q.queueSize());
        System.out.println("Is queue empty? " + q.isEmpty());
    }
}
