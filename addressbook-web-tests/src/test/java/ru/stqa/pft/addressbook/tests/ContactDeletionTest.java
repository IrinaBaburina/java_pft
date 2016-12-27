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
      app.contact().create(new GroupFormContacts("Irina", "Berg", "Lacosta", "RTT", "Halifax, Canada, NS", "+19994034225", "irina@hotmail.com", "test1"));
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
