package com.cmj;
abstract class Car //This is abstract class | Object can not be created for it
{
    boolean result;
    private String implementerName = "Karthick";
    String OfficeName = "OutOfBox";
    public abstract  void drive();

     public void payMusic(){
        System.out.println("pay music");
         activity();
    }

    private void activity(){
         System.out.println("activity : "+implementerName+" |"+result);
    }

    public static void checkStaticMethod(){
         System.out.println("check static method");
    }
}

abstract class WagonR extends Car //Since WagonR class not implement the drive method of abstract class car, it is updated ad abstract class
{
    public void reverseCamera(){
        System.out.println("reverse camera");
    }
}

class AdvanceWagonR extends WagonR // It is concrete class | Implements all the methods
{
    public void drive(){
        System.out.println("drive wagon");
    }
    public void powerWindow(){
        System.out.println("power window");
    }
}

public class AbstractClassTest {

    public static void main(String[] args) {
        Car car = new AdvanceWagonR();
        car.drive();
        car.payMusic();
        System.out.println( car.OfficeName);
        car.OfficeName = "FraudTeam";
        System.out.println("----------------------");
        WagonR wagonR = (WagonR)car;
        wagonR.reverseCamera();
        wagonR.payMusic();
        wagonR.drive();
        wagonR.checkStaticMethod();
        System.out.println( wagonR.OfficeName);
        System.out.println("----------------------");
        AdvanceWagonR advanceWagonR =  (AdvanceWagonR)car;
        advanceWagonR.drive();
        advanceWagonR.powerWindow();
        advanceWagonR.payMusic();
        advanceWagonR.reverseCamera();
        System.out.println(advanceWagonR.OfficeName);
        Car.checkStaticMethod();
    }

}
