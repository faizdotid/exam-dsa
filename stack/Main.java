// Kelas stack array
class StackArray {
    private int[] stack;
    private int top;
    private int maxSize;

    public StackArray(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack overflow!");
            return;
        }
        stack[++top] = data;
        System.out.println("Push: " + data);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow!");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return;
        }

        System.out.print("Stack (top ke bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackLinkedList {
    private StackNode top;

    public StackLinkedList() {
        this.top = null;
    }

    public void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
        System.out.println("Push: " + data);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow!");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return;
        }

        System.out.print("Stack (top ke bottom): ");
        StackNode current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        int[] numbers = {53, 64, 128, 113, 124, 248, 122, 134, 268, 280};

        System.out.println("=== STACK MENGGUNAKAN ARRAY ===");
        StackArray stackArray = new StackArray(15);

        for (int num : numbers) {
            stackArray.push(num);
        }
        stackArray.display();

        System.out.println("\n=== STACK MENGGUNAKAN LINKED LIST ===");
        StackLinkedList stackLinkedList = new StackLinkedList();

        for (int num : numbers) {
            stackLinkedList.push(num);
        }
        stackLinkedList.display();
    }
}
