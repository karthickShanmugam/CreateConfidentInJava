package com.cmj.collectTest;

import java.util.*;


class StudentMark implements Comparable<StudentMark>{
    String name;
    int marks;

    public StudentMark(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public int compareTo(StudentMark o) {
        return this.getMarks() < o.getMarks()?1:-1;
    }
}

public class ComparatorAndComparable {

    public static void main(String[] args) {
        //arraySortbeforeJava8();
        //comparatorExample();
        comparableExample();
    }


    public static void comparableExample() {
        List<StudentMark> studentMarks = new ArrayList<>();
        studentMarks.add(new StudentMark("Karthick",45));
        studentMarks.add(new StudentMark("David",100));
        studentMarks.add(new StudentMark("Julian",84));
        studentMarks.add(new StudentMark("Ram",90));

        for (StudentMark studentMark : studentMarks) {
            System.out.println(studentMark.getName()+":"+studentMark.getMarks() );
        }
        System.out.println("After sorting string");
        Collections.sort(studentMarks);
        for (StudentMark studentMark : studentMarks) {
            System.out.println(studentMark.getName()+":"+studentMark.getMarks() );
        }
    }

    public  static <T> T generateRamdom(T list){
        int index = 0;
        while(index<=9){
            double value = Math.random();
           // System.out.println("Match random values:"+ value);
            List d = (List)list;
            d.add((int)(value));
            index++;
        }
        return list;
    }

    public static void comparatorExample(){
      List<Integer> list = new ArrayList<Integer>();
        generateRamdom(list);
        System.out.println("Before storing");
        list.stream().forEach(System.out::println);
        System.out.println("after storing ascending");
        Collections.sort(list);
        list.stream().forEach(System.out::println);
        System.out.println("after storing descending");
        Comparator<Integer> obj = new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                return a < b ? 1 : -1;
            }
        };
        Collections.sort(list, obj);
        list.stream().forEach(System.out::println);
        System.out.println("after storing descending based mod");
        Collections.sort(list, (a,b)->a%100<b%100?1:-1);
        list.stream().forEach(System.out::println);

        System.out.println("----------String challenge----------");

        List<String > listString = Arrays.asList("Karthick", "Shanmugam", "Prema","sowmiya","krithika sri");
        Comparator<String> obj1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return -1;
                }
                return 1;
            }
        };
        Collections.sort(listString,obj1);
        listString.stream().forEach(System.out::println);
    }



    public static void arraySortBeforeJava8(){
        int[] studentMark =  new int[10];
        int index = 0;
        while(index<=9){
            double value = Math.random()*100;
            System.out.println("Match random values:"+ value);
            studentMark[index++] = (int)(value);
        }

        index = 0;
        while(index<=9){
            System.out.println("Index Position and value: "+index+" Values:"+studentMark[index]);
            index++;
        }

        System.out.println("After sorting");
        for(int i=0;i<studentMark.length;i++){
            for(int j=0;j<studentMark.length;j++){
                if(studentMark[i]<studentMark[j]){
                    int temp = studentMark[i];
                    studentMark[i] = studentMark[j];
                    studentMark[j] = temp;
                }
            }
        }
        index = 0;
        while(index<=9){
            System.out.println("Index Position and value: "+index+" Values:"+studentMark[index]);
            index++;
        }
    }
}
