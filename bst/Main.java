class BSTNode {
    int data;
    BSTNode left, right;

    public BSTNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinarySearchTree {
    private BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private BSTNode insertRec(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void inorder() {
        System.out.print("Inorder: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public void preorder() {
        System.out.print("Preorder: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(BSTNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorder() {
        System.out.print("Postorder: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(BSTNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(BSTNode root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        }

        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }
}

class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        int[] elements = {10, 17, 25, 4, 7, 9, 2, 15, 21, 27};

        System.out.println("Inserting elements: ");
        for (int element : elements) {
             bst.insert(element);
            System.out.println("Inserted: " + element);
        }

        System.out.println("\nTraversal results:");
        bst.inorder();
        bst.preorder();
        bst.postorder();

        System.out.println("\nSearch test:");
        System.out.println("Search 15: " + bst.search(15));
        System.out.println("Search 100: " + bst.search(100));
    }
}
