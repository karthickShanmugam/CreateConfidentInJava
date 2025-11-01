package com.cmj.streamTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicate {

    public static void main(String arg[]){

        List<String> name = Arrays.asList("karthick", "shanmugam", "vignesh", "shanmugam", "Prema", "vignesh", "sowmiya");
        List<String> result = name.stream().distinct().toList();
        result.stream().forEach(System.out::println);
        List<String> result1 = name.stream().distinct().collect(Collectors.toList());
        result1.stream().forEach(System.out::println);
    }
}
