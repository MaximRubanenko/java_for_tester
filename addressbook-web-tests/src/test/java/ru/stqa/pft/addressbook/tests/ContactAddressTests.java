package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {
  @Test
  public void TestContactAddress() {
    // Выполнить предусловия. Создать нужный контакт, если он несуществует.
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
              .withAddress("Moscow, Stornaya  bld 4/52 fl.   9")
              //.withAddress2("Tula, Pavlova 6 /2")
      );
    }
    app.goTo().gotoHomePage();
    ContactData contact = app.getContactHelper().allContact().iterator().next();
    ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);
    assertThat(contact.getAddress(),equalTo(cleaned(contactInfoFromEditForm.getAddress())));
    //assertThat(contact.getAddress2(),equalTo(contactInfoFromEditForm.getAddress2()));

  }

  public String cleaned(String address){
    return address.replaceAll("\\s+"," ");
  }

}
