// Parent class
abstract class Product {
    protected String name;
    protected double price;
    protected String expiryDate;

    public Product(String name, double price, String expiryDate) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    // Getter
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Abstract method untuk polymorphism
    public abstract void displayInfo();
}

// Child Class
class ElectronicProduct extends Product {
    private int warranty; // Garansi dalam tahun

    public ElectronicProduct(String name, double price, String expiryDate, int warranty) {
        super(name, price, expiryDate);
        this.warranty = warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    // Override method displayInfo
    @Override
    public void displayInfo() {
        System.out.println("=== PRODUK ELEKTRONIK ===");
        System.out.println("Nama: " + name);
        System.out.println("Harga: Rp" + String.format("%.1fE7", price / 10000000));
        System.out.println("Garansi: " + warranty + " tahun");
        System.out.println("Kedaluwarsa: " + expiryDate);
        System.out.println();
    }
}

// Child Class
class GroceryProduct extends Product {
    private double weight; // Berat dalam kg

    public GroceryProduct(String name, double price, String expiryDate, double weight) {
        super(name, price, expiryDate);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Polymorphism - Override method displayInfo
    @Override
    public void displayInfo() {
        System.out.println("=== PRODUK SEMBAKO ===");
        System.out.println("Nama: " + name);
        System.out.println("Harga: Rp" + price);
        System.out.println("Berat: " + weight + " kg");
        System.out.println("Kedaluwarsa: " + expiryDate);
        System.out.println();
    }
}

// Main class
class Main {
    public static void main(String[] args) {
        // Buat objek produk elektronik, laptop
        ElectronicProduct laptop = new ElectronicProduct("Laptop ASUS", 150000000, "30-12-2025", 2);

        // Buat objek produk sembako, beras
        GroceryProduct rice = new GroceryProduct("Beras Premium", 120000.0, "30-12-2025", 5.0);

        // Tampilkan informasi produk
        laptop.displayInfo();
        rice.displayInfo();
    }
}
