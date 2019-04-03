public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    //TODO добавить генерир массива, сравн время добавл
    private void run() {
        int[] arr = {1, -3, 4, -2, 7, -1, 2};
        Tree tree = new Tree();
        for (int n : arr) {
            tree.add(n);
        }
        System.out.println("Height: "+tree.height());
        tree.print();
        if ( tree.isBalanced() ) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }
    }
}