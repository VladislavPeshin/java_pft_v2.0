package ru.stqa.pft.sandbox;

import java.sql.SQLOutput;

public class Equality {

  public static void main(String[] args){
    String s1 = "firefox";
    String s2 = "firefox" + Math.sqrt(4.0);

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
  }
}
