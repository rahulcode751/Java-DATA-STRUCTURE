package Learning;

public class I_ImplementQueueUsingArray
{
    private int arr[];
    private int start, end, currSize, maxSize;
    public I_ImplementQueueUsingArray() {
        arr = new int[16];
        start = -1;
        end = -1;
        currSize = 0;
        maxSize = 16;
    }

    public I_ImplementQueueUsingArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        start = -1;
        end = -1;
        currSize = 0;
    }
    public void push(int newElement) {
        if (currSize == maxSize) {
            System.out.println("Queue is full\nExiting...");
            System.exit(1);
        }
        if (end == -1) {
            start = 0;
            end = 0;
        } else
            end = (end + 1) % maxSize;
        arr[end] = newElement;
        System.out.println("The element pushed is " + newElement);
        currSize++;
    }
    public int pop() {
        if (start == -1) {
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        int popped = arr[start];
        if (currSize == 1) {
            start = -1;
            end = -1;
        } else
            start = (start + 1) % maxSize;
        currSize--;
        return popped;
    }
    public int top() {
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[start];
    }
    public int size() {
        return currSize;
    }

    public static void main(String[] args)
    {
        I_ImplementQueueUsingArray queue = new I_ImplementQueueUsingArray(5);
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println("Top element is: " + queue.top());
        System.out.println("Queue size is: " + queue.size());
        System.out.println("Popped element is: " + queue.pop());
        System.out.println("Is queue empty? " + (queue.size() == 0));
    }
}
