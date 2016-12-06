package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;
import ru.stqa.pft.sandbox.Square;

/**
 * Created by iryamka on 11/25/2016.
 */
public class PointTests {

  @Test
  public void testDistance(){
    Point p1 = new Point(3, 5);
    Point p2 = new Point(7, 8);

    Assert.assertEquals(Math.sqrt((p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y)), 5.0);
  }
}
