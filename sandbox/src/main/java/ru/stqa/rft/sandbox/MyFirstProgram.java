package ru.stqa.rft.sandbox;

public class MyFirstProgram {
	
	public static void main (String[] args) {
      Square s = new Square(5);
      System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

      Rectangle r = new Rectangle(4,6);
      System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());


      Point p1 = new Point(2,3);
      Point p2  = new Point(7,6);




      System.out.println("расстояние между точками p1 и p2 = " + p1.distance(p2));
    }








}