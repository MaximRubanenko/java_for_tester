package ru.stqa.pft.addressbook.tests;

import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactPhoneTests extends TestBase {
  @Test
  public void TestContactPhones() {
    // Выполнить предусловия. Создать нужный контакт, если он несуществует.
    app.goTo().gotoHomePage();
    if (app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData()
              .withFirstname("Bob")
              .withLastname("Stewenson")
              .withHomePhone("111")
              .withMobilePhone("222")
              .withWorkPhone("333")
      );
    }
    app.goTo().gotoHomePage();
    ContactData contact = app.getContactHelper().allContact().iterator().next();
    ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);
    assertThat(contact.getHome(),equalTo(cleaned(contactInfoFromEditForm.getHome())));
    assertThat(contact.getMobile(),equalTo(cleaned(contactInfoFromEditForm.getMobile())));
    assertThat(contact.getWork(),equalTo(cleaned(contactInfoFromEditForm.getWork())));
    assertThat(contact,equalTo(contactInfoFromEditForm));
  }

  public String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }

}
