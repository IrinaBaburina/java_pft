package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
<<<<<<< HEAD
 * Created by iryamka on 12/13/2016.
 */
public class HelperBase {
  FirefoxDriver wd;
=======
 * Created by iryamka on 12/9/2016.
 */
public class HelperBase {
  public FirefoxDriver wd;
>>>>>>> origin/master

  public HelperBase(FirefoxDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }
<<<<<<< HEAD
=======

>>>>>>> origin/master
  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
