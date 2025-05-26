class Main {
    private String[] table;
    private int size;
    private int count;

    // Constructor
    public Main(int size) {
        this.size = size;
        this.table = new String[size];
        this.count = 0;
    }

    // Fungsi hash: jumlah nilai ASCII karakter mod size
    private int hashFunction(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum % size;
    }

    // Method untuk insert dengan linear probing
    public boolean insert(String key) {
        if (count >= size) {
            System.out.println("Hash table penuh!");
            return false;
        }

        int index = hashFunction(key);
        int originalIndex = index;

        System.out.printf("Inserting '%s' - Hash value: %d\n", key, index);

        // Linear probing untuk menangani collision
        while (table[index] != null) {
            System.out.printf("Collision detected at index %d! Trying next position...\n", index);
            index = (index + 1) % size;

            // Jika sudah kembali ke posisi awal, berarti table penuh
            if (index == originalIndex) {
                System.out.println("Hash table penuh!");
                return false;
            }
        }

        table[index] = key;
        count++;
        System.out.printf("'%s' inserted at index %d\n\n", key, index);
        return true;
    }

    // Method untuk search
    public int search(String key) {
        int index = hashFunction(key);
        int originalIndex = index;

        while (table[index] != null) {
            if (table[index].equals(key)) {
                return index;
            }
            index = (index + 1) % size;

            // Jika sudah kembali ke posisi awal
            if (index == originalIndex) {
                break;
            }
        }
        return -1; // Tidak ditemukan
    }

    // Method untuk menampilkan hash table
    public void display() {
        System.out.println("=== HASH TABLE ===");
        System.out.println("┌───────┬──────────────┐");
        System.out.println("│ Index │    Value     │");
        System.out.println("├───────┼──────────────┤");

        for (int i = 0; i < size; i++) {
            String value = (table[i] != null) ? table[i] : "null";
            System.out.printf("│  [%d]  │ %-12s │\n", i, value);
        }

        System.out.println("└───────┴──────────────┘");
        System.out.println("Total elements: " + count + "/" + size);
        System.out.println();
    }

    // Method untuk menampilkan detail hash calculation
    public void showHashCalculation(String key) {
        int sum = 0;
        System.out.printf("Hash calculation for '%s':\n", key);

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int ascii = (int) c;
            sum += ascii;
            System.out.printf("%c(%d) ", c, ascii);
            if (i < key.length() - 1) System.out.print("+ ");
        }

        System.out.printf("= %d\n", sum);
        System.out.printf("%d %% %d = %d\n\n", sum, size, sum % size);
    }

    public static void main(String[] args) {
        // Membuat hash table berukuran 10
        Main hashTable = new Main(10);

        // Data yang akan diinsert sesuai soal
        String[] items = {"Anting", "Baju", "Celana", "Gelas", "Gunting",
                "Handphone", "Buku", "Garpu", "Jarum", "Benang"};

        System.out.println("=== LINEAR PROBING HASH TABLE IMPLEMENTATION ===\n");

        // Menampilkan hash calculation untuk setiap item
        System.out.println("HASH CALCULATIONS:");
        System.out.println("==================");
        for (String item : items) {
            hashTable.showHashCalculation(item);
        }

        System.out.println("INSERTION PROCESS:");
        System.out.println("==================");

        // Insert semua items
        for (String item : items) {
            hashTable.insert(item);
        }

        // Menampilkan hash table final
        hashTable.display();

        // Testing search functionality
        System.out.println("SEARCH TESTING:");
        System.out.println("===============");

        String[] searchItems = {"Gelas", "Buku", "Laptop"}; // Laptop tidak ada

        for (String item : searchItems) {
            int index = hashTable.search(item);
            if (index != -1) {
                System.out.printf("'%s' ditemukan di index %d\n", item, index);
            } else {
                System.out.printf("'%s' tidak ditemukan\n", item);
            }
        }

        System.out.println("\n=== PROGRAM SELESAI ===");
    }
}
