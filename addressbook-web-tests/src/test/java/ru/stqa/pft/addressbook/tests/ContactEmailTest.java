package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase {
  @Test
  public void TestContactEmail() {
    app.goTo().gotoHomePage();
    if (app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData()
              .withFirstname("Bob")
              .withLastname("Stewenson")
              .withHomePhone("111-222")
              .withMobilePhone("+7(222)")
              .withWorkPhone("333 999 222")
              .withEmail("start@stop.ru")
              .withEmail2("bravo@next.com")
              .withEmail3("nike@prado.fi")
      );
    }

    app.goTo().gotoHomePage();
    ContactData contact = app.getContactHelper().allContact().iterator().next();
    ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);

    assertThat(contact.getEmail(), equalTo(contactInfoFromEditForm.getEmail()));
    assertThat(contact.getEmail2(), equalTo(contactInfoFromEditForm.getEmail2()));
    assertThat(contact.getEmail3(), equalTo(contactInfoFromEditForm.getEmail3()));
  }
}

