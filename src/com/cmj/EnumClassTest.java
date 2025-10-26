package com.cmj;

enum Status{
    Success, Failed, Pending
}
enum ComputerBrand{
    Dell(51500), HP(60430), MacBook, Lenovo(49760);
    int price;
    ComputerBrand(int price){
        this.price = price;
        System.out.println("Current class name: "+this.name());
    }

    ComputerBrand(){
        this.price = 92840;
        System.out.println("Current default class name: "+this.name());
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class EnumClassTest {
    public static void main(String[] args) {
         Status  status = Status.Success;
         System.out.println("Status is: "+status+" Position:"+ status.ordinal());
         System.out.println("Get Failed Status: "+Status.Failed);
         Status[] allEnumValues = Status.values();
         System.out.println("0 Position value: "+allEnumValues[0]);
         for(Status a : allEnumValues){
              System.out.println("Value is: "+a+" Position: "+a.ordinal());
         }
         System.out.println("Get Success Status: "+status.getClass().getSuperclass());
         System.out.println("-----------------");
        ComputerBrand[] computerBrands =  ComputerBrand.values();
        for(ComputerBrand c : computerBrands){
            System.out.println("Value is: "+c+" Position: "+c.ordinal() + "Price: "+c.getPrice());
        }
    }
}
