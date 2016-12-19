package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

public class ContactCreationTest extends TestBase {

    @Test
    public void testGroupContacts() {
        app.getNavigationHelper().gotoGroupPage();
        app.getContactHelper().addNewContact();
        app.getContactHelper().fillFormContact(new GroupFormContacts("Irina", "Baburina", "Lacosta", "RTT", "Halifax, Canada, NS", "+19994034225", "irina@hotmail.com", "test1"), true);
        app.getContactHelper().submitNewContact();
    }

}