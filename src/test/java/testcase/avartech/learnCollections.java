package testcase.avartech;


import org.checkerframework.checker.units.qual.K;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

public class learnCollections {
    public static void main(String[] args) {
        //interface list
        /*ArrayList<String> list = new ArrayList<>();

        list.add( "a1");
        list.add("a2");
        list.add("a3");
        list.add(3, "a4");
        list.set(3, "a5");
        //swap phan tu
        String temp = list.get(2);
        list.set(2, list.get(3));
        list.set(3, temp);
       for (int i = 0; i < list.size() ; i++){
           System.out.println(list.get(i));
       }
       // vector
        Vector<String> list1 = new Vector<>();
*/
       //linkedList
        //LinkedList<String> list2 = new LinkedList<>();
        // Set
        HashMap<String, String> map = new HashMap<>();
        map.put("fullname", "Tran Thi Yen");
        map.put("Age", "1");
        map.put("Address", "Hanam");
        System.out.println(map.get("fullname"));

    }

}
