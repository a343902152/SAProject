package project2;

import project2.adapter.BirdAdapter;
import project2.adapter.DogAdapter;
import project2.adaptee.BirdAction;
import project2.adaptee.DogAction;

public class Main {

    public static void main(String[] args) {
        BionicsRobot robot=new BionicsRobot();
        System.out.println("basic action:");
        robot.move();
        robot.cry();

        System.out.println("\nbird action:");
        robot.setAction(new BirdAdapter(new BirdAction()));
        robot.move();
        robot.cry();

        System.out.println("\ndog action:");
        robot.setAction(new DogAdapter(new DogAction()));
        robot.move();
        robot.cry();
    }
}
