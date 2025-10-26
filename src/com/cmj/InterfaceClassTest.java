package com.cmj;

interface ToRailWayStation{
    public static final String implementerName = "Karthick"; // Variable in interface are default public static final
    void useMobileAppToCallAuto();
    void payAmountToDriver();

    default void verifyTicket(){
        System.out.println("Verifying Ticket");
    }

    private void lockYourHome(){
            System.out.println("lock your home");
    };

    public static void activity(){
        System.out.println("activity");
    }
}

class PersonA implements ToRailWayStation{

    public void useMobileAppToCallAuto() {
            System.out.println("using Mobile App To Call Auto");
    }

    public void payAmountToDriver() {
            System.out.println("pay amount to driver");
    }
}

public class InterfaceClassTest {

    public static void main(String[] args) {

        ToRailWayStation toRailWayStation = new PersonA();
        toRailWayStation.useMobileAppToCallAuto();
        toRailWayStation.payAmountToDriver();
        toRailWayStation.verifyTicket();
        System.out.println(toRailWayStation.implementerName);
        //toRailWayStation.activity(); can not call static method via object
        ToRailWayStation.activity();
    }
}
