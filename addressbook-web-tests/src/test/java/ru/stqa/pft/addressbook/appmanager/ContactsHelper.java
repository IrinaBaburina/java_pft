package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

/**
  * Created by iryamka on 12/13/2016.
  */
public class ContactsHelper extends HelperBase {

  public ContactsHelper(WebDriver wd) {
    super(wd);
  }

  public void fillFormContact(GroupFormContacts groupFormContacts, boolean creation) {
    type(By.name("firstname"), groupFormContacts.getFirstname());
    type(By.name("lastname"), groupFormContacts.getLastname());
    type(By.name("nickname"), groupFormContacts.getNickname());
    type(By.name("company"), groupFormContacts.getCompany());
    type(By.name("address"), groupFormContacts.getAddress());
    type(By.name("mobile"), groupFormContacts.getMobile());
    type(By.name("email"), groupFormContacts.getEmail());

    if (creation == true) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupFormContacts.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void editContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitUpdate() {
    click(By.name("update"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void submitNewContact() {
    click(By.name("submit"));
  }

  public void createContact(GroupFormContacts contact) {
    addNewContact();
    fillFormContact(contact, true);
    submitNewContact();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }
}
