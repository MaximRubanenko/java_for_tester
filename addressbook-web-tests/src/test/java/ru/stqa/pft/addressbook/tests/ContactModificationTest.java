package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.goTo().gotoHomePage();
    if (app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(
              new ContactData()
                      .withFirstname("Bob")
                      .withLastname("Stewenson")
                      .withHomePhone("111-222")
                      .withMobilePhone("+7(222)")
                      .withWorkPhone("333 999 222")
                      .withEmail("start@stop.ru")
                      .withEmail2("bravo@next.com")
                      .withEmail3("nike@prado.fi")
                      .withAddress("Moscow, Stornaya  bld 4/52 fl.   9"));
    }
    Contacts before = app.getContactHelper().allContact();
    ContactData modifiedContacts = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContacts.getId())
            .withFirstname("Petr")
            .withLastname("Petrov");
    app.getContactHelper().initModifyContact(contact.getId());
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactUpdate();
    app.goTo().gotoHomePage();

    Contacts after = app.getContactHelper().allContact();
    Assert.assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContacts).withAdded(contact)));
  }
}
