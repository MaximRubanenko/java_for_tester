package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;


public class ContactDeletionTest extends TestBase{

  @Test
  public void testContactDeletion(){
      app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Nicke", "B", "Marley", "tst@test.ru"));
    }
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteContact();
  }
}
