package Learning;

public class I_ImplementStackUsingArray
{
    class stack {
        int size = 10000;
        int arr[] = new int[size];
        int top = -1;
        void push(int x) {
            top++;
            arr[top] = x;
        }
        int pop() {
            int x = arr[top];
            top--;
            return x;
        }
        int top() {
            return arr[top];
        }
        int size() {
            return top + 1;
        }
    }

    public static void main(String[] args)
    {
        I_ImplementStackUsingArray obj = new I_ImplementStackUsingArray();
        stack s = obj.new stack();
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.top());
        System.out.println(s.size());
    }
}
