package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

import java.util.HashSet;
import java.util.List;

/**
 * Created by iryamka on 12/16/2016.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new GroupFormContacts("Irina", "Berg", "Lacosta", "RTT", "Halifax, Canada, NS", "+19994034225", "irina@hotmail.com", "test1"));
      app.getNavigationHelper().gotoHomePage();
    }
    List<GroupFormContacts> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().editContact();
    GroupFormContacts contact = new GroupFormContacts(before.get(before.size() - 1).getId(), "Irina", "Berg", "Lacosta", "RTT", "Halifax, Canada, NS", "+19994034225", "irina@hotmail.com", "test1");
    app.getContactHelper().fillFormContact(contact, false);
    app.getContactHelper().submitUpdate();
    app.getNavigationHelper().gotoHomePage();
    List<GroupFormContacts> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
