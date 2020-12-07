package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTest extends TestBase {

  @Test (enabled = false)
  public void testContactDeletion() {
    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Nicke", "B", "Marley", "tst@test.ru"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.goTo().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
