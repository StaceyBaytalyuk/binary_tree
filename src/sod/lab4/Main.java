package sod.lab4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Tree smallTree = new Tree();
        printTreeInfo(smallTree);
        addElementsToTree(100_000, smallTree);
        printTreeInfo(smallTree);

        Tree bigTree = new Tree();
        addElementsToTree(1_000_000, bigTree);
        printTreeInfo(bigTree);
    }

    private void printTreeInfo(Tree tree) {
        System.out.println("Height: "+tree.height());
        tree.print();
        if ( tree.isBalanced() ) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }
        System.out.println("=====================");
    }

    private void addElementsToTree(int size, Tree tree) {
        int[] arr = generateArr(size);
        long start = System.currentTimeMillis();
        for (int n : arr) {
            tree.add(n);
        }
        double time = (double)(System.currentTimeMillis()-start)/1000;
        System.out.println("Insertion time of "+size+" elements: "+time+" seconds");
    }

    private int[] generateArr(int size) {
        return new Random().ints(size, -999, 1000).toArray();
    }

}