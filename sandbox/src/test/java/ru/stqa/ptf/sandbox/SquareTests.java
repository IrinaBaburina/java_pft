package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Square;

/**
 * Created by iryamka on 11/25/2016.
 */
public class SquareTests {

  @Test
  public void testArea() {
    Square s = new Square(4);
    Assert.assertEquals(s.area(), 16.0);

  }
}
