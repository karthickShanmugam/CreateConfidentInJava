package com.cmj.yaduInterviewQ.java8;

import com.cmj.yaduInterviewQ.java8.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class java8Test {

    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        String strInput = "heel and Feel";
        String[] stringarry =strInput.split(" ");
        // print even
        var even = myList.stream().filter(env->env%2==0).toList();
                System.out.println("even:" +even);
        // print even and old
        var evenAndOdd = myList.stream().collect(Collectors.partitioningBy(env->env%2==0));
        System.out.println("even:" +evenAndOdd);

        //Find the repetitive character from a word or sentence using java8

       var repetitiveSeqChar = strInput.chars().filter(c -> !Character.isWhitespace(c)).mapToObj(c->(char)c).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).collect(Collectors.toList());
        System.out.println("repetitive character from a word:" +repetitiveSeqChar);

        //reverse String

        var strR = Arrays.stream(stringarry).map(s -> new StringBuilder(s).reverse()).collect(Collectors.toList());

        System.out.println("reverse String"+strR);

        //      String strInput = "heel and heel for feel"; count word repeated
        String strInput2 = "heel and heel for feel";
        var repeatedSeqWord = Arrays.stream(strInput2.split("  ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("count word repeated"+repeatedSeqWord);


        // Employee max salary by department
        List<Employee> employeeList = Arrays.asList(
        new Employee("ram","male","IT",110000.00),
       new Employee("jam","female","HR",40000.00),
       new Employee("jaua","male","LT",10000.00),
         new Employee("jaya","female","IT",4000000.00)
    );


        var emplist =employeeList.stream().
        collect(Collectors.
                groupingBy(Employee ::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("Employee max salary by department"+emplist);







    }
}
