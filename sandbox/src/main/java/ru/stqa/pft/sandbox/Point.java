package ru.stqa.pft.sandbox;

/**
 * Created by iryamka on 11/21/2016.
 */
public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;

  }

  public double distance(Point p2) {
    return Math.sqrt((p2.x - x) * (p2.x - x) + (p2.y - y) * (p2.y - y));
  }
}