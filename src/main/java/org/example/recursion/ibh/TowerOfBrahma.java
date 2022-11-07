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


    public long printAndCountSteps(int N, int from, int to, int aux) {
        //Base Condition
        long steps = 0;
        if(N == 1) {
            System.out.println("move disk " +N+ " from rod " +from+ " to rod " +to);
            return 1;
        }
        //Hypothesis
        steps += printAndCountSteps(N-1, from, aux, to);
        //Induction
        System.out.println("move disk " +N+ " from rod " +from+ " to rod " +to);
        steps += 1;
        return steps += printAndCountSteps(N-1, aux, to, from);

    }

    public static void main(String[] args) {
        TowerOfBrahma obj = new TowerOfBrahma();
        //obj.printSteps("source", "destination", "helper", 3);
        obj.printAndCountSteps(3, 1, 2, 3);
    }


}
