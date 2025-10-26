package com.cmj;

class Mother{

    String name = "Sowmiya";

    public void show(){
        System.out.println("show mother name: "+name);
    }

    class krithika{
        String name = "Krithika";
        public void show(){
            System.out.println("show krithika name: "+name);
        }
    }

    static class karthick{
        String name = "karthick";
        public void show(){
            System.out.println("show karthick name: "+name);
        }
    }
}


class InnerClassTest {

    public static void main(String[] args) {

         Mother mother = new Mother();
         mother.show();
         System.out.println(mother.name);
         System.out.println("----------------------");
         Mother.krithika krithika = mother.new krithika();
         krithika.show();
         System.out.println(krithika.name);
         System.out.println("---------------------");
         Mother.karthick karthick = new Mother.karthick();
        karthick.show();
        System.out.println(karthick.name);
    }
}
