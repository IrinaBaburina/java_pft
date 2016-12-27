package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

import java.util.Comparator;
import java.util.List;

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
    List<GroupFormContacts> before = app.contact().list();
    int index = before.size() - 1;
    GroupFormContacts contact = new GroupFormContacts().withId(before.get(index).getId()).withFirstname("Irina").withLastname("Berg").withNickname("Lacosta").withCompany("RTT")
            .withAddress("Moscow").withMobile("+19994034225").withEmail("irina@hotmail.com").withGroup("Test1");
    app.contact().modifyContacts(index, contact);
    app.goTo().homePage();
    List<GroupFormContacts> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super GroupFormContacts> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
