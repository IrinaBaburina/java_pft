package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

import java.util.List;

/**
 * Created by iryamka on 12/16/2016.
 */
public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsC() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new GroupFormContacts()
              .withFirstname("Irina").withLastname("Berg").withNickname("Lacosta").withCompany("RTT")
              .withAddress("Moscow").withMobile("+19994034225").withEmail("irina@hotmail.com").withGroup("Test1"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactDeletion() {
    List<GroupFormContacts> before = app.contact().list();
    app.contact().delete(before);
    app.goTo().homePage();
    List<GroupFormContacts> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
    }
}
