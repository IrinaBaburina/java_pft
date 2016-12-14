package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
/**
 * Created by iryamka on 12/13/2016.
 */
public class ApplicationManager {
 FirefoxDriver wd;

  private ContactsHelper contactsHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper  ;
  private GroupHelper groupHelper;

  public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactsHelper = new ContactsHelper(wd);
        sessionHelper.login("admin", "secret");
      }

           public void stop() {
         wd.quit();
      }

           public GroupHelper getGroupHelper() {
        return groupHelper;
      }

           public NavigationHelper getNavigationHelper() {
        return navigationHelper;
      }
 }