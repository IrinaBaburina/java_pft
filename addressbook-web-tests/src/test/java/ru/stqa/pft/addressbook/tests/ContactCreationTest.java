package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testGroupContacts() {
    app.goTo().homePage();
    List<GroupFormContacts> before = app.contact().list();
    GroupFormContacts contact = new GroupFormContacts("Irina", "Berg", "Lacosta", "RTT", "Halifax, Canada, NS", "+19994034225", "irina@hotmail.com", "test1");
    app.contact().create(contact);
    app.goTo().homePage();
    List<GroupFormContacts> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super GroupFormContacts> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}