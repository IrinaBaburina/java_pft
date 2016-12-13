package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
<<<<<<< HEAD
 * Created by iryamka on 12/13/2016.
 */
public class NavigationHelper extends HelperBase{

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
}
=======
 * Created by iryamka on 12/9/2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }
>>>>>>> origin/master

  public void gotoGroupPage() {
      click(By.linkText("groups"));
  }
}
