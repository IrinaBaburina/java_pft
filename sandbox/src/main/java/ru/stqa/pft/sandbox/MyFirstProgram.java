package ru.stqa.pft.sandbox;

public class MyFirstProgram {

   public static void main(String[] args) {

     Point p1 = new Point();
     p1.x = 3;
     p1.y = 5;

     Point p2 = new Point();
     p2.x = 7;
     p2.y = 8;
     
     double d = distance(p1, p2);
     System.out.println("Расстояние между точками равно " + d);
   }

   public static double distance(Point p1, Point p2){
     return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y));
   }

}
