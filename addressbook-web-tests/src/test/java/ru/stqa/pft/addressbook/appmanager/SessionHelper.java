package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
<<<<<<< HEAD
 * Created by iryamka on 12/13/2016.
=======
 * Created by iryamka on 12/9/2016.
>>>>>>> origin/master
 */
public class SessionHelper extends HelperBase {

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }
<<<<<<< HEAD
  public void login(String username, String password) {

    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
=======

  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));

>>>>>>> origin/master
  }
}
