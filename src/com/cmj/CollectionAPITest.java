package com.cmj;

import java.util.*;

public class CollectionAPITest {

    public static void main(String[] args) {

        Collection collection = new ArrayList();
        collection.add(10);
        collection.add(20);
        collection.add(30);
        System.out.println("Size of collection: "+collection.size());
        for(Object o : collection){
            int i = (int)o;
            System.out.println("Original Value:"+i+" Multiply by 10 value: "+i*10);
        }

        System.out.println("############ Collection interface with generic ################### ");
        Collection<Integer> collection1 = new ArrayList<>();
        collection1.add(53);
        collection1.add(34);
        collection1.add(98);
        System.out.println("Size of collection: "+collection1.size());
        for(Object o : collection1){
            int i = (int)o;
            System.out.println("Original Value:"+i+" Multiply by 10 value: "+i*10);
        }

        System.out.println("############ List interface with generic ################### ");
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(23);
        list.add(11);
        list.add(0);
        list.add(24);
        list.add(24);
        list.add(null);
        list.add(null);
        list.add(2,100);

        System.out.println("Size of collection: "+list.size());
        list.stream().forEach(System.out::println);
        System.out.println("1 index value: "+list.get(1)+" index of: "+list.indexOf(list.get(1)));


        System.out.println("############ Set interface with generic ################### ");
        Set<Integer> set = new HashSet<>();
        set.add(null);
        set.add(23);
        set.add(11);
        set.add(0);
        set.add(85);
        set.add(24);
        set.add(24);
        set.add(null);
        set.add(null);
        System.out.println("Size of collection: "+set.size());
        set.stream().forEach(System.out::println);
        //System.out.println("1 index value"+set.get(1)); Will not support get

        Iterator<Integer> values = set.iterator();
        while(values.hasNext()){
            System.out.println("Iterating set using iterator: "+values.next());
        }

        System.out.println("############ Linked Hash Set interface with generic ################### ");
        Integer[] input = {null,23,11,0,85,24,24,null, null};
        Set<Integer> Linkedset = new LinkedHashSet<>(Arrays.asList(input));

        System.out.println("Size of collection: "+Linkedset.size());
        Linkedset.stream().forEach(System.out::println);
        //System.out.println("1 index value"+set.get(1)); Will not support get
        Iterator<Integer> lsvalues = Linkedset.iterator();
        while(lsvalues.hasNext()){
            System.out.println("Iterating set using iterator: "+lsvalues.next());
        }

        System.out.println("############ Tree  Set interface with generic ################### ");
        Integer[] input1 = {23,11,0,85,24,24};
        Set<Integer> treeset = new TreeSet<>(Arrays.asList(input1));

        System.out.println("Size of collection: "+treeset.size());
        Linkedset.stream().forEach(System.out::println);
        //System.out.println("1 index value"+set.get(1)); Will not support get

        Iterator<Integer> tsvalues = treeset.iterator();
        while(tsvalues.hasNext()){
            System.out.println("Iterating set using iterator: "+tsvalues.next());
        }


    }
}
