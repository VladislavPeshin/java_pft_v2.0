package ru.stqa.pft.sandbox;
/*
public class Point {
  public double x1;
  public double y1;
  public double x2;
  public double y2;

  public Point p1 (double x1, double y1){
    this.x1 = x1;
    this.y1 = y1;
  }

  public  Point p2 (double x2, double y2){
    this.x2 = x2;
    this.y2 = y2;
  }

  public double distance(Point p1, Point p2) {
    double d = Math.sqrt((p2.x2 - p1.x1) * (p2.x2 - p1.x1) + (p2.y2 - p1.y1) * (p2.y2 * p1.y1));
    return d;
  }

  @Override
  public String toString(){
    return  this.x1 + ";" + this.y1;
  }

  public  String toString1(){
    return this.x2 + ";" + this.y2;
  }
}
*/



class Point{
  private double x;
  private double y;

  public Point(double x1, double y1) {
    this.x = x1;
    this.y = y1;
  }

  public double distance(Point p2){
    return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y));
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public String toString() {
    return "Point{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }
}

