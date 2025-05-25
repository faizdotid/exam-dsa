class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SingleLinkedList {
    private Node head;

    public SingleLinkedList() {
        this.head = null;
    }

    // a. Insert di akhir list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // b. Insert setelah nilai tertentu
    public void insertAfter(int afterValue, int newValue) {
        Node current = head;
        while (current != null && current.data != afterValue) {
            current = current.next;
        }
        if (current != null) {
            Node newNode = new Node(newValue);
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Berhasil insert " + newValue + " setelah " + afterValue);
        } else {
            System.out.println("Nilai " + afterValue + " tidak ditemukan!");
        }
    }

    // c. Delete nilai tertentu
    public void delete(int value) {
        if (head == null) {
            System.out.println("List kosong!");
            return;
        }

        // Jika yang dihapus adalah head
        if (head.data == value) {
            head = head.next;
            System.out.println("Berhasil hapus " + value);
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Berhasil hapus " + value);
        } else {
            System.out.println("Nilai " + value + " tidak ditemukan!");
        }
    }

    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List kosong!");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        // a. Insert semua angka
        int[] numbers = {43, 5, 9, 42, 6, 11, 41, 7, 13, 100, 12, 70, 24, 40, 36, 16, 35, 14, 30, 25};

        System.out.println("a. Insert semua angka:");
        for (int num : numbers) {
            list.insert(num);
        }
        list.display();

        // b. Insert 59 setelah 100
        System.out.println("\nb. Insert 59 setelah 100:");
        list.insertAfter(100, 59);
        list.display();

        // c. Delete angka 40
        System.out.println("\nc. Delete angka 40:");
        list.delete(40);
        list.display();
    }
}
