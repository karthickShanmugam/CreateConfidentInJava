package com.cmj;

class CastingA{
    public void show(){
        System.out.println("showA");
    }

    public void showAA(){
        System.out.println("showAA");
    }
}

class CastingB extends CastingA{
    public void show(){
        System.out.println("showB");
    }

    public void showBB(){
        System.out.println("showBB");
    }
}

public class UpCasting_DownCasting {
    public static void main(String[] args) {
       CastingA a = new CastingB(); // Upcasting
        a.show();
        a.showAA();

        CastingB b = (CastingB) a;  //down casting
        b.show();
        b.showBB();
        b.showAA();
    }
}

