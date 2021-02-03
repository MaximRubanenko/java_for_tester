package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.goTo().gotoHomePage();
    if (app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(
                      new ContactData()
                              .withFirstname("Mike")
                              .withLastname("Jonson")
                              .withHomePhone("111-222")
                              .withMobilePhone("+7(222)")
                              .withWorkPhone("333 999 222")
                              .withEmail("start@stop.ru")
                              .withEmail2("bravo@next.com")
                              .withEmail3("nike@prado.fi")
                              .withAddress("Moscow, Stornaya  bld 4/52 fl.   9"));
    }
    Contacts before = app.getContactHelper().allContact();
    ContactData deletedContact = before.iterator().next();
    app.getContactHelper().delete(deletedContact);
    app.goTo().gotoHomePage();
    Contacts after = app.getContactHelper().allContact();
    assertThat(after, equalTo(before.without(deletedContact)));
    
  }
}
