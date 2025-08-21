package Learning;

import java.util.*;

public class III_QueueUsingStack
{
    Stack<Integer> stack1;

    III_QueueUsingStack() {
        stack1 = new Stack<>();
    }

    public void enqueue(int x) {
        Stack<Integer> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int dequeue() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.pop();
    }

    public int peek() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.peek();
    }

    public int size() {
        return stack1.size();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        III_QueueUsingStack queue = new III_QueueUsingStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front element is: " + queue.peek());
        System.out.println("Queue size is: " + queue.size());
        System.out.println("Dequeued element is: " + queue.dequeue());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
