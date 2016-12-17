import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;

import javax.crypto.CipherInputStream;

import objectexplorer.Chain;
import objectexplorer.MemoryMeasurer;
import com.google.common.base.*;

public class Main {

    public static void main(String[] args) {
        final int testsNumber = 100000;
        long memory = MemoryMeasurer.measureBytes(new HashMap());
        //long addResult[] = new long[7];
        //long containsResult[] = new long[7];
        //long removeResult[] = new long[7];
        //int i = 0;

      //  ArrayDeque<Double> ad = new ArrayDeque<>();
//        ArrayList<Double> al = new ArrayList<>();
//        HashSet<Double> hs = new HashSet<>();
//        LinkedList<Double> ll = new LinkedList<>();
//        Stack<Double> s = new Stack<>();
//        SynchronousQueue<Double> sq = new SynchronousQueue<>();
//        Vector<Double> v = new Vector<>();


//        CollectionsTests t = new CollectionsTests(ad);
//        t.testAndWrite(testsNumber);
        /*addResult[i] = t.testAdd(testsNumber);
        containsResult[i] = t.testContains(testsNumber);
        removeResult[i] = t.testRemove(testsNumber);
        i++;*/

        //CollectionsTests t = new CollectionsTests(al);
       // System.out.println(MemoryMeasurer.measureBytes(5));
//        t.testAndWrite(testsNumber);
        /*addResult[i] = t.testAdd(testsNumber);
        containsResult[i] = t.testContains(testsNumber);
        removeResult[i] = t.testRemove(testsNumber);
        i++;*/

//        t = new CollectionsTests(hs);
//        t.testAndWrite(testsNumber);
        /*addResult[i] = t.testAdd(testsNumber);
        containsResult[i] = t.testContains(testsNumber);
        removeResult[i] = t.testRemove(testsNumber);
        i++;*/

//        t = new CollectionsTests(ll);
//        t.testAndWrite(testsNumber);
//        /*addResult[i] = t.testAdd(testsNumber);
//        containsResult[i] = t.testContains(testsNumber);
//        removeResult[i] = t.testRemove(testsNumber);
//        i++;*/
//
//        t = new CollectionsTests(s);
//        t.testAndWrite(testsNumber);
//        /*addResult[i] = t.testAdd(testsNumber);
//        containsResult[i] = t.testContains(testsNumber);
//        removeResult[i] = t.testRemove(testsNumber);
//        i++;*/
//
//        t = new CollectionsTests(sq);
//        t.testAndWrite(testsNumber);
//        /*addResult[i] = t.testAdd(testsNumber);
//        containsResult[i] = t.testContains(testsNumber);
//        removeResult[i] = t.testRemove(testsNumber);
//        i++;*/
//
//        t = new CollectionsTests(v);
//        t.testAndWrite(testsNumber);
        /*addResult[i] = t.testAdd(testsNumber);
        containsResult[i] = t.testContains(testsNumber);
        removeResult[i] = t.testRemove(testsNumber);
        i++;
        sort(addResult);
        sort(containsResult);
        sort(removeResult);

        for(int j = 0; j < addResult.length; j ++) {
            System.out.println(addResult[j]);
        }*/

    }
/*
    static void sort(long[] t) {
        for(int i = 0; i < t.length; i ++) {
            for(int j = 0; j < t.length - 1; j ++) {
                if(compare(t[j], t[j + 1])) {
                    long tmp = t[j+1];
                    t[j+1] = t[j];
                    t[j] = tmp;
                }
            }
        }
    }

    static boolean compare(long l1, long l2 ) {
        return l1 > l2;
    }*/
}
