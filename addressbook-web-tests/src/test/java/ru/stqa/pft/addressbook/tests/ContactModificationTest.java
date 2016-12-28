package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by iryamka on 12/16/2016.
 */
public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsC() {
    app.goTo().homePage();
    if (! app.contact().isThereAContact()) {
      app.contact().create(new GroupFormContacts()
              .withFirstname("Irina").withLastname("Berg").withNickname("Lacosta").withCompany("RTT")
              .withAddress("Moscow").withMobile("+19994034225").withEmail("irina@hotmail.com").withGroup("Test1"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    GroupFormContacts modifiedContact = before.iterator().next();
    GroupFormContacts contact = new GroupFormContacts().withId(modifiedContact.getId()).withFirstname("Irina").withLastname("Berg").withNickname("Lacosta").withCompany("RTT")
            .withAddress("Moscow").withMobile("+19994034225").withEmail("irina@hotmail.com").withGroup("Test1");
    app.contact().modifyContacts(contact);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
