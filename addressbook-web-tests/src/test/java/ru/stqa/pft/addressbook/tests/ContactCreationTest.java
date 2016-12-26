package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testGroupContacts() {
    app.getNavigationHelper().gotoHomePage();
    List<GroupFormContacts> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new GroupFormContacts("Irina", "Berg", "Lacosta", "RTT", "Halifax, Canada, NS", "+19994034225", "irina@hotmail.com", "test1"));
    app.getNavigationHelper().gotoHomePage();
    List<GroupFormContacts> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}