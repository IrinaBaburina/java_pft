package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupContacts extends TestBase {

    @Test
    public void testGroupContacts() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().addNewContact();
        app.getGroupHelper().fillFormContact(new GroupFormContacts("Irina", "Baburina", "Lacosta", "IBM", "Halifax, Canada, NS", "+19024034224", "irinababurina@gmail.com"));
        app.getGroupHelper().submitNewContact();
    }

}