package com.cmj.streamTest;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

class FlatMapTest{

    String name;
    List<String> data;

    public FlatMapTest(String name, List<String> data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}

class HotelMenu{
    String DishName;
    boolean IsVegetarian;
    double price;
    FoodType type;

    public HotelMenu(FoodType type, double price, boolean isVegetarian, String dishName) {
        this.type = type;
        this.price = price;
        IsVegetarian = isVegetarian;
        DishName = dishName;
    }

    public String getDishName() {
        return DishName;
    }

    public void setDishName(String dishName) {
        DishName = dishName;
    }

    public boolean isVegetarian() {
        return IsVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        IsVegetarian = vegetarian;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }
}
enum FoodType{
        STARTED, MAIN_COURSE, CURRY, DESSERTS, OTHERS
}



public class SortTest {
    static List<HotelMenu> menu = new ArrayList<>();

    public static void getNonVegLowToHigh(){
         List<HotelMenu> lowtohigh = new ArrayList<>();
        for(HotelMenu hotelMenu: menu){
            if(!hotelMenu.IsVegetarian){
                lowtohigh.add(hotelMenu);
            }
        }

        Comparator<HotelMenu> obj =  new Comparator<HotelMenu>() {
            @Override
            public int compare(HotelMenu o1, HotelMenu o2) {
                return Double.compare(o1.getPrice(),o2.getPrice());
            }
        };

        Collections.sort(lowtohigh, obj);
        for(HotelMenu HotelMenu: lowtohigh){
            System.out.println("Dish name: "+HotelMenu.getDishName()+ " Price: "+HotelMenu.getPrice());
        }
    }


public static void main(String[] arg){
    menu.add(new HotelMenu(FoodType.STARTED,150.2,false,"Tandoori"));
    menu.add(new HotelMenu(FoodType.STARTED,242.20,false,"Chicken 65"));
    menu.add(new HotelMenu(FoodType.STARTED,200,true,"Paneer"));
    menu.add(new HotelMenu(FoodType.MAIN_COURSE,450,false,"Biryani"));
    menu.add(new HotelMenu(FoodType.CURRY,300,true,"Gobi Mamchurian"));
    menu.add(new HotelMenu(FoodType.CURRY,280,false,"chettinad gravy"));

    for(HotelMenu HotelMenu: menu){
        System.out.println("Dish name: "+HotelMenu.getDishName()+ " Price: "+HotelMenu.getPrice());
    }

    System.out.println("#########Low to high before java 8##########");
    getNonVegLowToHigh();
    System.out.println("#######Low to high after java 8########");
    Comparator<HotelMenu> obj =  new Comparator<HotelMenu>() {
        @Override
        public int compare(HotelMenu o1, HotelMenu o2) {
            return Double.compare(o1.getPrice(),o2.getPrice());
        }
    };
    List<String> result = menu.stream().filter(menu->!menu.IsVegetarian).sorted(Comparator.comparing(HotelMenu::getPrice)).map(HotelMenu::getDishName).collect(Collectors.toList());
    for(String resul: result){
        System.out.println("Dish name: "+resul);
    }

    System.out.println("####### Filter only vegetarian menu using stream 8########");
    List<String> answer = menu.stream().filter(menu->menu.IsVegetarian).map(HotelMenu::getDishName).collect(Collectors.toList());
    for(String resul: answer){
        System.out.println("Dish name: "+resul);
    }

    System.out.println("####### Full Data using stream 8########");
    menu.stream().forEach(d->System.out.println(d.getDishName()));

    System.out.println("####### Limit using stream 8########");
    menu.stream().limit(2).forEach(d->System.out.println(d.getDishName()));

    System.out.println("####### Limit using stream 8########");
    menu.stream().skip(3).forEach(d->System.out.println(d.getDishName()));

    System.out.println("####### Number of character of string stream 8########");
    List<String> school = Arrays.asList("SDA","CEO", "Kamaraj", "karthick","shanmugam", "Karthick Shanmugam");
    school.stream().map(s->s.length()).forEach(System.out::println);

    System.out.println("####### Map of string stream 8########");
    List<String> school1 = Arrays.asList("SDA","CEO", "Kamaraj", "karthick","shanmugam", "Karthick Shanmugam");
    Map<String, Integer> data11 = school.stream().collect(Collectors.toMap(d -> d, d -> d.length()));
    for(String a : data11.keySet()){
        System.out.println("Key: "+a+" Value: "+data11.get(a));
    }

    System.out.println("####### flatMap of string stream 8########");
    List<FlatMapTest> flatMap = new ArrayList<>();
    flatMap.add(new FlatMapTest("karthick",Arrays.asList("good","bad", "sad", "happy")));
    flatMap.add(new FlatMapTest("shanmugam",Arrays.asList("angary","cold", "hot", "bad")));
    List<List<String>> f1ss = flatMap.stream().map(d -> d.getData()).collect(Collectors.toList());
    System.out.println(f1ss);

    List<String> f2ss = flatMap.stream().map(d -> d.getData()).flatMap(List::stream).collect(Collectors.toList());
    System.out.println(f2ss);

    System.out.println("####### anyMatch of string stream 8########");
    List<String> anyM = Arrays.asList("good","bad", "sad","happy");
    System.out.println(anyM.stream().anyMatch(d->d.equalsIgnoreCase("sad")));

    System.out.println("####### AllMatch of string stream 8########");
    List<String> allM = Arrays.asList("sad","sad", "sad","sad");
    System.out.println(allM.stream().allMatch(d->d.equalsIgnoreCase("sad")));

    System.out.println("####### nonMatch of string stream 8########");
    List<String> nonM = Arrays.asList("sad","sad", "sad","sad");
    System.out.println(nonM.stream().noneMatch(d->d.equalsIgnoreCase("saad")));

    System.out.println("####### findFirst of string stream 8########");
    List<String> findF = Arrays.asList("sad","happy", "hanger","smile");
    Optional<String> findFs = allM.stream().findFirst();
    System.out.println(findFs);
    System.out.println(findFs.get());

    System.out.println("####### find any of string stream 8########");
    List<String> findAny = Arrays.asList("sad","happy", "hanger","smile");
    Optional<String> findany = findAny.stream().findAny();
    System.out.println(findany);
    System.out.println(findany.get());

    System.out.println("####### find any paralal of string stream 8########");
    List<String> paralal = Arrays.asList("sad","happy", "hanger","smile");
    Optional<String> paralala = paralal.stream().parallel().findAny();
    System.out.println(paralala);
    System.out.println(paralala.get());


}
}
