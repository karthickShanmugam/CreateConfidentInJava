package com.cmj;

import java.util.Objects;

class ObjectClassTest {

    String name = "Samsung";
    String model = "Laptop";
    double amount = 51000.33;

    @Override
    public String toString() {
        return "ObjectClassTest{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ObjectClassTest that = (ObjectClassTest) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(name, that.name) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, amount);
    }
}

class MainOCT{

    public static void main(String[] args){
        ObjectClassTest object = new ObjectClassTest();
        ObjectClassTest object1 = new ObjectClassTest();
        System.out.println(object);
        System.out.println(object.toString());
        boolean result;
        System.out.println(object.equals(object1));
        System.out.println(object == object1);
        ObjectClassTest object2 = new ObjectClassTest();
        object2.name = "Dell";
        System.out.println(object.equals(object2));
    }

}
