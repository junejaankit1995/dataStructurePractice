package org.example.recursion.ibh;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class JosephusCircle6 {

    /*
    n : number of persons in a circle
    k : index to be killed at every Iteration
     */
    public int josephus(int n, int k) {
        //Edge Case
        if( n < k )
            return -1;
        ArrayList<Integer> persons = new ArrayList<>();
        //second parameter is exclusive
        //Initiating List of person with original Position
        IntStream.range(1,n+1).forEach( index -> persons.add(index) );
        int startIndex = 0;
        solve(persons, --k, startIndex);
        return persons.get(0);
    }

    private void solve(ArrayList<Integer> persons, int k, int startIndex) {
        /*
        Base Condition
                        I/P
                     | 1 | 2 | 3 | 4 | 5 | , K = 1 , start = 0
                          |
                     | 1 | 3 | 4 | 5 | , K = 1 , start = 1
                          |
                     | 1 | 3 | 5 | , K = 1 , start = 2
                          |
                     | 3 | 5 | , K = 1 , start = 0
                          |
                     | 3 | , K = 1 , start = 0
                   Only one left
        */
        if(persons.size() == 1) {
            return;
        }
        //Small Input
        startIndex = (startIndex + k) % persons.size();
        persons.remove(startIndex);

        solve(persons, k, startIndex);

        //Induction
        // No Need to add ith removed Index Its already dead .
    }

    public static void main(String[] args) {
        JosephusCircle6 obj = new JosephusCircle6();
        System.out.println( obj.josephus(40, 7));
    }
}
