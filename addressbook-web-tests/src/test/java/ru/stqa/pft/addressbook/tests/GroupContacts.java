package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.GroupFormContacts;

public class GroupContacts extends TestBase {

    @Test
    public void testGroupContacts() {

        app.getNavigationHelper().gotoGroupPage();
        addNewContact();
        fillFormContact(new GroupFormContacts("Irina", "Baburina", "Lacosta", "IBM", "Halifax, Canada, NS", "+19024034224", "irinababurina@gmail.com"));
        submitNewContact();

    }

    public void submitNewContact() {
        app.getGroupHelper().submitGroupCreation();
    }

    public void addNewContact() {
        app.getGroupHelper().wd.findElement(By.linkText("add new")).click();
    }
}
