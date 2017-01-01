package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


/**
 * Created by iryamka on 12/28/2016.
 */
public class ContactPhoneTest extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData infoFromContactForm = app.contact().getInfoFromContactForm(contact);

    MatcherAssert.assertThat(contact.getHome(), CoreMatchers.equalTo(cleaned(infoFromContactForm.getHome())));
    MatcherAssert.assertThat(contact.getMobile(), CoreMatchers.equalTo(cleaned(infoFromContactForm.getMobile())));
    MatcherAssert.assertThat(contact.getWork(), CoreMatchers.equalTo(cleaned(infoFromContactForm.getWork())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}

