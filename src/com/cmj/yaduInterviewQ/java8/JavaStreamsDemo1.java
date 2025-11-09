package com.cmj.yaduInterviewQ.java8;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class JavaStreamsDemo1 {

    public static void main(String arg[]) throws IOException {
         //reverseTheString();
         // findTheDuplicateCountInList();
         //mergeTwoArraySortASC();
         //readFromConsoleAndCreateList();
         //fileWriteAndRead();
        // Need to work on file upload


    }
    public static void fileWriteAndRead() throws IOException {
        BufferedWriter obj = new BufferedWriter(new FileWriter("test.txt"));
        obj.write("Hello world");
        obj.write("\nWelcome to oracle");
        obj.close();

        BufferedReader obj1 = new BufferedReader(new FileReader("test.txt"));
        String line1;
        while (( line1 = obj1.readLine())!=null){
            System.out.println(line1);
        }
    }

    public static void readFromConsoleAndCreateList() throws IOException {

        InputStreamReader InputStreamObj = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(InputStreamObj);
        Integer row = Integer.valueOf(buffer.readLine());

        List<Integer> finalResult = IntStream.range(0, row).mapToObj(index ->
                {
                    String data;
                    try {
                        data = buffer.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return data;
                }
        ).map(String::trim).map(Integer::parseInt).toList();

        finalResult.forEach(System.out::println);
    }

    public static void mergeTwoArraySortASC(){
        //In java 8 Desc
        int[] a = {4,1,7,5};
        int[] b = {2,6,4,8};
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).boxed().sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();
        Arrays.stream(c).forEach(System.out::print);
        System.out.println("\n#####");

        //Before java 8 Asc
        int[] cc = new int[a.length+b.length];
        int index = 0;
        for(int i=0;i<a.length;i++){
            cc[index++]=a[i];
        }
        for(int j=0;j<b.length;j++){
            cc[index++]=b[j];
        }
        Arrays.sort(cc);
        Arrays.stream(cc).forEach(System.out::print);
    }

    public static void findTheDuplicateCountInList(){
        //In java 8
        List<String> fruitsList = Arrays.asList("Apple", "Orange", "Grape", "Pomegranate", "Apple", "Grape", "Grape");
        Map<String, Long> result = fruitsList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Find The Duplicate Count In List In Java 8: "+result);

        //Before java 8
        Map<String, Integer> fruitsCount = new HashMap<>();
        for(String fruit : fruitsList){
            if(fruitsCount.get(fruit)==null){
                fruitsCount.put(fruit, 1);
            } else{
                fruitsCount.put(fruit,fruitsCount.get(fruit)+1);
            }
        }
        System.out.println("Find The Duplicate Count In List Before Java 8:"+fruitsCount);
    }

    //Oracle company
    public static void reverseTheString(){
        //In java 8
        String data = "Welcome to oracle";
        String reversed =  IntStream.range(0, data.length()).map(index -> data.charAt(data.length()-1-index)).collect(StringBuilder::new,StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println("Reverse The String In Java 8: "+reversed);

        //Before java 8
        StringBuilder reverseString =  new StringBuilder(data).reverse();
        System.out.println("Reverse The String before Java 8: "+reverseString);
    }
}
