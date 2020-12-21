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
    // Выполнить предуслови. Создать нужный контакт, если он несуществует.
    app.goTo().gotoHomePage();
    ContactData contact = app.getContactHelper().allContact().iterator().next();
    ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);
    assertThat(contact,equalTo(contactInfoFromEditForm));
  }

}
