package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iryamka on 12/24/2016.
 */
public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python","PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python","PHP");
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");
    languages.add("PHP");

    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Я хочу выучить " + languages.get(i));
    }
  }
}
