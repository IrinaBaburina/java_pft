package ru.stqa.pft.sandbox;

/**
 * Created by iryamka on 12/17/2016.
 */
public class Equality {

  public static void main(String[] args) {
    String s1 = "firefox";
    String s2 = new String(s1);

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
  }
}
