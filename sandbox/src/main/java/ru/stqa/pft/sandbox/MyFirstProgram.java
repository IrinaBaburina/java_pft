package ru.stqa.pft.sandbox;

public class MyFirstProgram {

   public static void main(String[] args) {

     Square s = new Square(4);
     System.out.println("Площать квадрата со стороной " + s.l + " = " + s.area());

     Point p1 = new Point(3, 5);

     Point p2 = new Point(7, 8);

     double d = distance(p1, p2);
     System.out.println("Расстояние между точками Point1 c координатами " + " (" + p1.x + " , " + p1.y + ") " + " и Point2 с координатами " + " (" + p2.x + " , " + p2.y + ") " + " равно " + d + ".");
   }

  public static double area(Square s){
    return s.l * s.l;
  }

   public static double distance(Point p1, Point p2){
     return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y));
   }
}
