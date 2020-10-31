package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testArea(){
    Point p1 = new Point(5, 5);
    Point p2 = new Point(25, 25);
    Assert.assertEquals(p1.distance(p2), 28.284271247461902);
  }
}
