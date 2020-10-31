package ru.stqa.pft.sandbox;

public class RunClass {

  public static void main(String[] args) {
    Point p1 = new Point(5,5);
    Point p2 = new Point(25,25);
    System.out.println(p1.distance(p2));
    System.out.println(p2.distance(p1));
  }
}