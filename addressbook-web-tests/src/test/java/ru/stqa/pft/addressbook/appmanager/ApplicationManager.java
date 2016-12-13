package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
<<<<<<< HEAD
 * Created by iryamka on 12/13/2016.
 */
public class ApplicationManager {
  FirefoxDriver wd;

  private ContactsHelper contactsHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper  ;
=======
 * Created by iryamka on 12/9/2016.
 */
public class ApplicationManager {

  FirefoxDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
>>>>>>> origin/master
  private GroupHelper groupHelper;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
<<<<<<< HEAD
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactsHelper = new ContactsHelper(wd);
=======
    wd.get("http://localhost/addressbook/index.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
>>>>>>> origin/master
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
<<<<<<< HEAD
     wd.quit();
=======
    wd.quit();
>>>>>>> origin/master
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
