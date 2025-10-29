package com.cmj;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> student = new HashMap<>();
        student.put("karthick",86);
        student.put("Vignesh", 90);
        student.put("Sowmiya",90);
        student.put("Krithika", 100);
        student.put("karthick", 46);
        System.out.println(student.keySet());
        for(String key : student.keySet()) {
            System.out.println("For Key: "+key + " Value is: " +student.get(key));
        }

        System.out.println("################ HashTable #############");

        Map<String, Integer> student1 = new Hashtable<>();
        student1.put("karthick",86);
        student1.put("Vignesh", 90);
        student1.put("Sowmiya",90);
        student1.put("Krithika", 100);
        student1.put("karthick", 46);
        System.out.println(student1.keySet());
        for(String key : student1.keySet()) {
            System.out.println("For Key: "+key + " Value is: " +student1.get(key));
        }

    }
}
