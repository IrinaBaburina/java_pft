package ru.stqa.pft.sandbox;

public class MyFirstProgram {

   public static void main(String[] args) {
     hello("world");
     hello("Irina");
     hello("friends");

     Square s = new Square(4);
     System.out.println("Площать квадрата со стороной " + s.l + " = " + s.area());

     Rectangle r = new Rectangle(3, 7);
     System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
   }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
}
