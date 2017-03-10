package Stacks;

public class RemoveAdjacentDuplicate {
    public static void main(String[] args) throws Exception {
        CharStackArray stack = new CharStackArray(15);
        char[] dupliactes = { 'a', 'z', 'x', 'x', 'z', 'y' };
        stack.removeAdjacentDuplicate(dupliactes);
    }

}

class CharStackArray {
    private char[] array;
    private int top;
    private int capacity;

    public void removeAdjacentDuplicate(char[] arr) throws Exception {
        for (int i = 0; i < arr.length; i++) {
            if (isEmpty()) { // if stack is empty
                push(arr[i]);
                display();
                System.out.println();
            } else {
                int count = 0;
                int j = i;
                /*
                 * while top of stack is equal to next value in array (ie same
                 * adjacent values)
                 */
                while (j < arr.length && peek() == arr[j]) {
                    count++; // count of same occurences
                    j++;
                }
                if (count == 0) { // no same occurence
                    push(arr[i]); // push to stack
                    display();
                    System.out.println();
                } else {
                    for (int k = 1; k < count; k++) // skip the array index for
                        // same adjacent duplicates
                        i++;
                    pop(); // pop the duplicate value from stack
                    display();
                    System.out.println();

                }
            }

        }
    }

    public CharStackArray(int cap) {
        capacity = cap;
        array = new char[capacity];
        top = -1;
    }

    public void push(char data) {
        array[++top] = data;
    }

    public char pop() throws Exception {
        return array[top--];
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + "->");
        }
    }

    public char peek() throws Exception {
        return array[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

}
