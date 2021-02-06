package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testCreationContact() {
    app.goTo().gotoHomePage();
    Contacts before = app.getContactHelper().allContact();
    File photo = new File("src/test/resources/medved.png");
    ContactData contact = //new ContactData().withFirstname("Nicke").withLastname("Marley");
            new ContactData()
                    .withFirstname("Bob")
                    .withLastname("Stewenson")
                    .withHomePhone("111-222")
                    .withMobilePhone("+7(222)")
                    .withWorkPhone("333 999 222")
                    .withEmail("start@stop.ru")
                    .withEmail2("bravo@next.com")
                    .withEmail3("nike@prado.fi")
                    .withAddress("Moscow, Stornaya  bld 4/52 fl.   9")
                    .withPhoto(photo);

    app.getContactHelper().createContact(contact);
    Contacts after = app.getContactHelper().allContact();
    assertThat(after, equalTo(before.withAdded(contact)));
  }

}
