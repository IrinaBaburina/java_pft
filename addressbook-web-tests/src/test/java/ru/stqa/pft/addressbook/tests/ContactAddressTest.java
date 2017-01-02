package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by iryamka on 1/1/2017.
 */
public class ContactAddressTest extends TestBase {

  @Test
  public void testContactAddress() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData infoFromContactForm = app.contact().getInfoFromContactForm(contact);

    assertThat(contact.getAddress(), equalTo(infoFromContactForm.getAddress()));
  }
}
