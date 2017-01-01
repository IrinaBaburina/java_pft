package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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
      app.contact().create(new ContactData()
              .withFirstname("Irina").withLastname("Berg").withNickname("Lacosta").withCompany("RTT")
              .withAddress("Moscow").withMobile("+19994034225").withHome("11111").withWork("22222").withEmail("irina@hotmail.com").withGroup("test1"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Irina").withLastname("Berg").withNickname("Lacosta").withCompany("RTT")
            .withAddress("Moscow").withMobile("+19994034225").withHome("11111").withWork("22222").withEmail("irina@hotmail.com").withGroup("test1");
    app.contact().modifyContacts(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
