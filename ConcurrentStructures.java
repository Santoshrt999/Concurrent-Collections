/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentstructures;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Santosh Goteti
 * Concurrent Collections
 */
public class ConcurrentStructures extends Thread {

    /**
     * @param args the command line arguments
     */
    static ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<String, Integer>();

    public void run() {

        try {

            Thread.sleep(1000);//sleeps for a while
        } catch (Exception e) {
            e.printStackTrace();
        }
        chm.put("D", 4);
    }

    public static void main(String... args) throws IllegalArgumentException, InterruptedException {

        chm.put("A", 1);
        chm.put("B", 2);
        chm.put("C", 3);
        ConcurrentStructures c = new ConcurrentStructures();
        c.start();
        Set s1 = chm.keySet(); // remember to create a variable Set and pass keyset.

        Iterator itr = s1.iterator();
        while (itr.hasNext()) {
            String s = (String) itr.next();
            System.out.println("Main thread Iterting " + s + " " + chm.values());//use chm.values() to know when the values get inside the iterator, when printed to the console.
            Thread.sleep(1000);//once sleeping, void run child thread invoked.
        }
        System.out.println(chm);//final output
    }

}
