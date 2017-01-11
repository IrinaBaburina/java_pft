package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by iryamka on 1/1/2017.
 */
public class ContactInfoTest  extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData viewInfoContact = app.contact().getInfoFromContactView(contact);
    app.goTo().homePage();
    ContactData infoFromContactForm = app.contact().getInfoFromContactForm(contact);



    assertThat(infoFromContactForm, equalTo(viewInfoContact));
  }
}

