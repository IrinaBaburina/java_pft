package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class GroupContacts extends TestBase {

    @Test
    public void testGroupContacts() {

        gotoGroupPage();
        addNewContact();
        fillFormContact(new GroupFormContacts("Irina", "Baburina", "Lacosta", "IBM", "Halifax, Canada, NS", "+19024034224", "irinababurina@gmail.com"));
        submitNewContact();

    }

    private void submitNewContact() {
        wd.findElement(By.name("submit")).click();
    }

    private void fillFormContact(GroupFormContacts groupFormContacts) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(groupFormContacts.getFirstname());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(groupFormContacts.getLastname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(groupFormContacts.getNickname());
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(groupFormContacts.getCompany());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(groupFormContacts.getAddress());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(groupFormContacts.getMobile());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(groupFormContacts.getEmail());
    }

    private void addNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }
}
