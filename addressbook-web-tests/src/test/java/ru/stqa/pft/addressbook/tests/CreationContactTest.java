package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class CreationContactTest extends TestBase {

  @Test
  public void testCreationContact() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Nicke", "B", "Marley", "tst@test.ru"));
    app.sumbitContactCreation();
    app.returnToHomePage();
  }
}
