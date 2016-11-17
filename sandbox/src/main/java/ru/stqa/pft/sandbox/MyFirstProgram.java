package ru.stqa.pft.sandbox;

public class MyFirstProgram {

   public static void main(String[] args) {
     hello("world");
     hello("Irina");
     hello("friends");

     double l = 4;
     System.out.println("Площать квадрата со стороной " + l + " = " + area(l));

     double a = 3;
     double b = 7;
     System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));
   }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(double len) {
    return len * len;
  }

  public static double area(double a, double b) {
    return a * b;
  }
}
