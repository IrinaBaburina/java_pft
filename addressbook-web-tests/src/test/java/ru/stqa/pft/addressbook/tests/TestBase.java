package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

/**
 * Created by iryamka on 12/7/2016.
 */
public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

  public void fillFormContact(GroupFormContacts groupFormContacts) {
      app.getGroupHelper().wd.findElement(By.name("firstname")).click();
      app.getGroupHelper().wd.findElement(By.name("firstname")).clear();
      app.getGroupHelper().wd.findElement(By.name("firstname")).sendKeys(groupFormContacts.getFirstname());
      app.getGroupHelper().wd.findElement(By.name("lastname")).click();
      app.getGroupHelper().wd.findElement(By.name("lastname")).clear();
      app.getGroupHelper().wd.findElement(By.name("lastname")).sendKeys(groupFormContacts.getLastname());
      app.getGroupHelper().wd.findElement(By.name("nickname")).click();
      app.getGroupHelper().wd.findElement(By.name("nickname")).clear();
      app.getGroupHelper().wd.findElement(By.name("nickname")).sendKeys(groupFormContacts.getNickname());
      app.getGroupHelper().wd.findElement(By.name("company")).click();
      app.getGroupHelper().wd.findElement(By.name("company")).clear();
      app.getGroupHelper().wd.findElement(By.name("company")).sendKeys(groupFormContacts.getCompany());
      app.getGroupHelper().wd.findElement(By.name("address")).click();
      app.getGroupHelper().wd.findElement(By.name("address")).clear();
      app.getGroupHelper().wd.findElement(By.name("address")).sendKeys(groupFormContacts.getAddress());
      app.getGroupHelper().wd.findElement(By.name("mobile")).click();
      app.getGroupHelper().wd.findElement(By.name("mobile")).clear();
      app.getGroupHelper().wd.findElement(By.name("mobile")).sendKeys(groupFormContacts.getMobile());
      app.getGroupHelper().wd.findElement(By.name("email")).click();
      app.getGroupHelper().wd.findElement(By.name("email")).clear();
      app.getGroupHelper().wd.findElement(By.name("email")).sendKeys(groupFormContacts.getEmail());
  }
}
