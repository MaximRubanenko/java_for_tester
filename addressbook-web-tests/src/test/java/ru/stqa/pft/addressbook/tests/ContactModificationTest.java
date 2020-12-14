package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.goTo().gotoHomePage();
    if (app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData().withFirstname("Bob").withLastname("Stewenson"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().initModifyContact(before.size());
    ContactData contact = new ContactData().withId(before.get(before.size() - 1).getId()).withFirstname("Petr").withLastname("Petrov");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactUpdate();
    app.goTo().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}
