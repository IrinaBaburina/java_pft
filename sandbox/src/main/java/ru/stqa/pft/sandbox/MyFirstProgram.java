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

     double z = 14;
     double w = 4;
     double y = 12;
     System.out.println("Периметр треугольника со сторонами " + z + " , " + w + " и " + y + " = " + area(z, w, y));

     int a = 6;
     int b = 18;
     int c = 3;
     int d = 11;
     int n = 1;
     System.out.println("Число " + a + " в кубе будет " + " = " + number(a));
     System.out.println("Число " + b + " в кубе будет " + " = " + number(b));
     System.out.println("Число " + c + " в кубе будет " + " = " + number(c));
     System.out.println("Число " + d + " в кубе будет " + " = " + number(d));
     System.out.println("Число " + n + " в кубе будет " + " = " + number(n));

     double g = 25;
     double k = 4096;
     double i = 16;
     System.out.println("Если извлечь корень из числа " + g + " , то результат будет " + " = " + number(g));
     System.out.println("Если извлечь корень из числа " + k + " , то результат будет " + " = " + number(k));
     System.out.println("Если извлечь корень из числа " + i + " , то результат будет " + " = " + number(i));
   }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(double z, double w, double y){
    return z + w + y;
  }

  public static int number(int a){
    return a*a*a;
  }

  public static double number(double g){
    return Math.sqrt(g);
  }
}
