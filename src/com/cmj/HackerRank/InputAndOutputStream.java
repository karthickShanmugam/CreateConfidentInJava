package com.cmj.HackerRank;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputAndOutputStream {

    public static void main(String[] a) throws IOException {

        System.out.println("Hello");

        InputStreamReader obj = new InputStreamReader(System.in);
        BufferedReader obj1 = new BufferedReader(obj);
        int count = Integer.parseInt(obj1.readLine());

        List<Integer> finalResult = IntStream.range(0, count).mapToObj(i -> {
            try {
                return obj1.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

        finalResult.stream().forEach(System.out::println);
        System.out.println("String revers");
        String name = "Karthick Shanmugam";
        System.out.println(name.length());
        String dday = IntStream.range(0, name.length()).map(c -> {System.out.println(c); return name.charAt(name.length() -1 - c);})
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println("String revers print dday: "+dday);

      List<String> dataStringList = Arrays.asList("apple", "orange", "grape", "apple");
        Map<String, Long> dat = dataStringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


    }
}