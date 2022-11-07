package org.example.recursion.ibh;

public class TowerOfBrahma {

    public void printSteps(String sourc, String dest, String help, int n) {
        //Base Condition
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + sourc + " to " + dest + ".");
            return;
        }
        // Hypothesis (smaller input)
        printSteps(sourc, help, dest, n - 1);
        System.out.println("Move disc " + n + " from " + sourc + " to " + dest + ".");
        //Induction
        printSteps(help, dest, sourc, n - 1);
    }

    public static void main(String[] args) {
        TowerOfBrahma obj = new TowerOfBrahma();
        obj.printSteps("source", "destination", "helper", 3);
    }


}
