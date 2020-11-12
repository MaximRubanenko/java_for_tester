package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactDeletionTest extends TestBase{

  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().gotoHomePage();
    if (app.getContactHelper().count("selected[]") > 0) {
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteContact();
    } else {
      Assert.fail("There are no contacts to delete");
    }
  }
}
