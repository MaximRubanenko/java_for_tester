package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

// Пока не работает
public class ContactDeletionTest extends TestBase{

  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
  }
}
