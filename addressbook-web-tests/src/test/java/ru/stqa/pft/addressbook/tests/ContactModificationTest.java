package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Nicke", "B", "Marley", "tst@test.ru"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().initModifyContact(before.size());
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Petr", "B", "Petrov", "tst@test.ru");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactUpdate();
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    before.remove(before.size()-1);
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}
