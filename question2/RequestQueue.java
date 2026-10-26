public class RequestQueue {
    private char[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public RequestQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new char[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(char c) {
        if (size < capacity) {
            rear = (rear + 1) % capacity;
            queue[rear] = c;
            size++;
        } else {
            System.err.println("Queue Overflow");
        }
    }

    public char dequeue() {
        if (!isEmpty()) {
            char c = queue[front];
            front = (front + 1) % capacity;
            size--;
            return c;
        }
        return '\0';
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
// Refactor checkpoint 1 for question2 code formatting

// Refactor checkpoint 2 for question2 code formatting

// Refactor checkpoint 3 for question2 code formatting
