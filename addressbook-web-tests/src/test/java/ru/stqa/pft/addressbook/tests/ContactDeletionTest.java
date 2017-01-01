package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by iryamka on 12/16/2016.
 */
public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsC() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Irina").withLastname("Berg").withNickname("Lacosta").withCompany("RTT")
              .withAddress("Moscow").withMobile("+19994034225").withHome("11111").withWork("22222").withEmail("irina@hotmail.com").withGroup("test1"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
    }
}
