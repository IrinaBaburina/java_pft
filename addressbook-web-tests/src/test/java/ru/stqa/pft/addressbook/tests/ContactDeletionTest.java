package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

/**
 * Created by iryamka on 12/16/2016.
 */
public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new GroupFormContacts("Irina", "Baburina", "Lacosta", "RTT", "Halifax, Canada, NS", "+19994034225", "irina@hotmail.com", "test1"), true);
    }
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlert();
    app.getNavigationHelper().gotoHomePage();

  }
}
