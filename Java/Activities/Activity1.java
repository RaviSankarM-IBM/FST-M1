package Activities;

import Examples.String;

public class Activity1 {

    public static void main(String[] args) {
        Car toyota = new Car();
        toyota.make = 2014;
        toyota.color = "Black";
        toyota.transmission = "Manual";

        //Using Car class method
        toyota.displayCharacteristics();
        toyota.accelerate();
        toyota.brake();
    }

}
