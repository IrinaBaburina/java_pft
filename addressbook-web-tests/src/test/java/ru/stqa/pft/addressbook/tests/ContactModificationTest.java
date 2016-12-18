package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

/**
 * Created by iryamka on 12/16/2016.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().editContact();
    app.getGroupHelper().fillFormContact(new GroupFormContacts("Irina", "Berg", "Mouse", "RTT", "Halifax, Canada, NS", "+19994034225", "irina@hotmail.com", null), false);
    app.getContactHelper().submitUpdate();
    app.getNavigationHelper().gotoHomePage();
  }
}
