package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupFormContacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void create(GroupFormContacts contact) {
    addNewContact();
    fillFormContact(contact, true);
    submitNewContact();
    contactCache = null;
  }

  public void modifyContacts(GroupFormContacts contact) {
    selectContactById(contact.getId());
    editContact();
    fillFormContact(contact, false);
    submitUpdate();
    contactCache = null;
  }

  public void delete(GroupFormContacts contact) {
    selectContactById(contact.getId());
    deleteContact();
    contactCache = null;
    closeAlert();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = element.findElement(By.xpath("//td[3]")).getText();
      String lastname = element.findElement(By.xpath("//td[2]")).getText();
      contactCache.add(new GroupFormContacts().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return new Contacts(contactCache);

  }
}
