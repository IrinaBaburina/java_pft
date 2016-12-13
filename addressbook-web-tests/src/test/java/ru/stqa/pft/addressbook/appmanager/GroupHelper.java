package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;
<<<<<<< HEAD
import ru.stqa.pft.addressbook.tests.GroupFormContacts;

/**
 * Created by iryamka on 12/13/2016.
=======

/**
 * Created by iryamka on 12/9/2016.
>>>>>>> origin/master
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
<<<<<<< HEAD

=======
>>>>>>> origin/master
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }
<<<<<<< HEAD

  public void submitNewContact() {
    click(By.name("submit"));
  }

  public void fillFormContact(GroupFormContacts groupFormContacts) {
    type(By.name("firstname"), groupFormContacts.getFirstname());
    type(By.name("lastname"), groupFormContacts.getLastname());
    type(By.name("nickname"), groupFormContacts.getNickname());
    type(By.name("company"), groupFormContacts.getCompany());
    type(By.name("address"), groupFormContacts.getAddress());
    type(By.name("mobile"), groupFormContacts.getMobile());
    type(By.name("email"), groupFormContacts.getEmail());
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }
=======
>>>>>>> origin/master
}
