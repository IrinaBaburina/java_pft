package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.SplittableRandom;

/**
 * Created by iryamka on 12/13/2016.
 */
public class ContactsHelper extends HelperBase {

  public ContactsHelper(WebDriver wd) {
    super(wd);
  }

  public void fillFormContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("home"), contactData.getHome());
    type(By.name("work"), contactData.getWork());
    type(By.name("email"), contactData.getEmail());

    if (creation == true) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void editContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void editContactById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
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

  public void create(ContactData contact) {
    addNewContact();
    fillFormContact(contact, true);
    submitNewContact();
    contactCache = null;
  }

  public void modifyContacts(ContactData contact) {
    selectContactById(contact.getId());
    editContact();
    fillFormContact(contact, false);
    submitUpdate();
    contactCache = null;
  }

  public void delete(ContactData contact) {
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
      String[] phones = element.findElement(By.xpath("//td[6]")).getText().split("\n");
      String mobile = phones[1];
      String home = phones[0];
      String work = phones[2];
      contactCache.add(new ContactData().withId(id).withFirstname(firstname)
              .withLastname(lastname).withMobile(mobile).withHome(home).withWork(work));
    }
    return new Contacts(contactCache);
  }

  public ContactData getInfoFromContactForm(ContactData contact) {
    editContactById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");

    return new ContactData().withId(contact.getId()).withFirstname(firstname)
            .withLastname(lastname).withMobile(mobile).withHome(home).withWork(work);

  }
}


