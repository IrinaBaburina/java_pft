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

     Triangle t = new Triangle();
     t.z = 14;
     t.w = 4;
     t.y = 12;
     System.out.println("Периметр треугольника со сторонами " + t.z + " , " + t.w + " и " + t.y + " = " + area(t));

     Cube c = new Cube();
     c.a = 6;
     System.out.println("Число " + c.a + " в кубе будет " + " = " + number(c));


     Kor k = new Kor();
     k.g = 25;
     System.out.println("Если извлечь корень из числа " + k.g + " , то результат будет " + " = " + number(k));

   }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(Triangle t){
    return t.z + t.w + t.y;
  }

  public static int number(Cube c){
    return c.a*c.a*c.a;
  }

  public static double number(Kor k){
    return Math.sqrt(k.g);
  }
}
