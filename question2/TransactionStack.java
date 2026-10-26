public class TransactionStack {
    private char[] stack;
    private int top;
    private int capacity;

    public TransactionStack(int capacity) {
        this.capacity = capacity;
        this.stack = new char[capacity];
        this.top = -1;
    }

    public void push(char c) {
        if (top < capacity - 1) {
            stack[++top] = c;
        } else {
            System.err.println("Stack Overflow");
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return stack[top--];
        }
        return '\0';
    }

    public char peek() {
        if (!isEmpty()) {
            return stack[top];
        }
        return '\0';
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
// Refactor checkpoint 1 for question2 code formatting

// Refactor checkpoint 2 for question2 code formatting

// Refactor checkpoint 3 for question2 code formatting

// Refactor checkpoint 4 for question2 code formatting

// Refactor checkpoint 5 for question2 code formatting

// Refactor checkpoint 1 for question2 code formatting

// Refactor checkpoint 2 for question2 code formatting

// Refactor checkpoint 3 for question2 code formatting
