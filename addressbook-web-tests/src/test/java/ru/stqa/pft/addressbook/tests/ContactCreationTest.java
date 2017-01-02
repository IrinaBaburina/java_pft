package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testGroupContacts() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Irina").withLastname("Berg").withNickname("Lacosta").withCompany("RTT")
            .withAddress("Moscow").withMobile("+19994034225").withHome("11111").withWork("22222")
            .withEmail("irina@hotmail.com").withEmail2("irina@mail.com").withEmail3("i@hot.com").withGroup("test1");
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupContacts() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Irina'").withLastname("Berg").withNickname("Lacosta").withCompany("RTT")
            .withAddress("Moscow").withMobile("+19994034225").withHome("11111").withWork("22222")
            .withEmail("irina@hotmail.com").withEmail2("irina@mail.com").withEmail3("i@hot.com").withGroup("test1");
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}