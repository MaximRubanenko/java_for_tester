package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testCreationContact() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Nicke", "B", "Marley", "tst@test.ru"));
    app.getContactHelper().sumbitContactCreation();
    app.returnToHomePage();
  }
}
