package Learning;

import java.util.*;

public class III_ImplementStackUsingQueue
{
    Queue<Integer> queue1;

    III_ImplementStackUsingQueue() {
        queue1 = new LinkedList<>();
    }

    public void push(int x){
        Queue<Integer> queue2 = new LinkedList<>();
        while(!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        queue1.add(x);
        while(!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
    }
    public int pop(){
        if(queue1.isEmpty()) {
            return -1;
        }
        int top = queue1.peek();
        queue1.poll();
        return top;
    }
    public int top(){
        if(queue1.isEmpty()) {
            return -1;
        }
        return queue1.peek();
    }
    public int size(){
        return queue1.size();
    }
    public boolean isEmpty(){
        return queue1.isEmpty();
    }
    public static void main(String[] args)
    {
        III_ImplementStackUsingQueue stack = new III_ImplementStackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element is: " + stack.top());
        System.out.println("Stack size is: " + stack.size());
        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
