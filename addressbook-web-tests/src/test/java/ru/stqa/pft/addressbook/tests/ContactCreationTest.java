package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testGroupContacts() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    GroupFormContacts contact = new GroupFormContacts()
            .withFirstname("Irina").withLastname("Berg").withNickname("Lacosta").withCompany("RTT")
            .withAddress("Moscow").withMobile("+19994034225").withEmail("irina@hotmail.com").withGroup("test1");
    app.contact().create(contact);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}