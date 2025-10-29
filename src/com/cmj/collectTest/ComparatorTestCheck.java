package com.cmj.collectTest;

import java.util.*;
import java.util.function.Consumer;

class Student implements Comparable<Student>{

    String name;
    int age;

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}

public class ComparatorTestCheck {

public static void main(String[] args) {

    List<Integer> list = new ArrayList<Integer>();
    list.add(88);
    list.add(31);
    list.add(22);
    list.add(37);
    list.stream().forEach(System.out::println);
    System.out.println("After sorting");
    Collections.sort(list);
    list.stream().forEach(System.out::println);

    Comparator <Integer> comparator = (Integer o1, Integer o2) -> {
            if(o1>o2)
                return 1;
            else
                return -1;
        };

    Collections.sort(list,comparator);


    List<Integer> list1 = Arrays.asList(88,31,22,45,35,77);

    Consumer<Integer> c =o -> System.out.println(o);
    list1.stream().forEach(o -> System.out.println(o));

    System.out.println("After sorting");
    List<Integer> list2 = Arrays.asList(88,31,22,45,35,77);
    int h =   list2.stream().filter(d->d%2==0).map(d->d*2).reduce(0,(a,b)->a+b);

    System.out.println(h);
    list2.stream().forEach(o -> System.out.println(o));

}

}
