package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

import java.util.List;

/**
 * Created by iryamka on 12/16/2016.
 */
public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new GroupFormContacts("Irina", "Berg", "Lacosta", "RTT", "Halifax, Canada, NS", "+19994034225", "irina@hotmail.com", "test1"));
      app.getNavigationHelper().gotoHomePage();
    }
    List<GroupFormContacts> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlert();
    app.getNavigationHelper().gotoHomePage();
    List<GroupFormContacts> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
    }
}
