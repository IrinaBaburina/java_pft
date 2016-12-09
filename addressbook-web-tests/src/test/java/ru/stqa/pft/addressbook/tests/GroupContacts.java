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

    public void fillFormContact(GroupFormContacts groupFormContacts) {
        app.getGroupHelper().wd.findElement(By.name("firstname")).click();
        app.getGroupHelper().wd.findElement(By.name("firstname")).clear();
        app.getGroupHelper().wd.findElement(By.name("firstname")).sendKeys(groupFormContacts.getFirstname());
        app.getGroupHelper().wd.findElement(By.name("lastname")).click();
        app.getGroupHelper().wd.findElement(By.name("lastname")).clear();
        app.getGroupHelper().wd.findElement(By.name("lastname")).sendKeys(groupFormContacts.getLastname());
        app.getGroupHelper().wd.findElement(By.name("nickname")).click();
        app.getGroupHelper().wd.findElement(By.name("nickname")).clear();
        app.getGroupHelper().wd.findElement(By.name("nickname")).sendKeys(groupFormContacts.getNickname());
        app.getGroupHelper().wd.findElement(By.name("company")).click();
        app.getGroupHelper().wd.findElement(By.name("company")).clear();
        app.getGroupHelper().wd.findElement(By.name("company")).sendKeys(groupFormContacts.getCompany());
        app.getGroupHelper().wd.findElement(By.name("address")).click();
        app.getGroupHelper().wd.findElement(By.name("address")).clear();
        app.getGroupHelper().wd.findElement(By.name("address")).sendKeys(groupFormContacts.getAddress());
        app.getGroupHelper().wd.findElement(By.name("mobile")).click();
        app.getGroupHelper().wd.findElement(By.name("mobile")).clear();
        app.getGroupHelper().wd.findElement(By.name("mobile")).sendKeys(groupFormContacts.getMobile());
        app.getGroupHelper().wd.findElement(By.name("email")).click();
        app.getGroupHelper().wd.findElement(By.name("email")).clear();
        app.getGroupHelper().wd.findElement(By.name("email")).sendKeys(groupFormContacts.getEmail());
    }

    public void addNewContact() {
        app.getGroupHelper().wd.findElement(By.linkText("add new")).click();
    }
}
