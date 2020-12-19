package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactPhoneTests extends TestBase {
  @Test
  public void TestContactPhones() {
    // Выполнить предуслови. Создать нужный контакт, если он несуществует.
    app.goTo().gotoHomePage();
    ContactData contact = app.getContactHelper().allContact().iterator().next();
    ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);
  }

}
