package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (app.getContactHelper().count("selected[]") > 0) {
      app.getContactHelper().selectContact();
      app.getContactHelper().initModifyContact();
      app.getContactHelper().fillContactForm(new ContactData("Nicke", "B", "Marley", "tst@test.ru"));
      app.getContactHelper().submitContactUpdate();
      app.returnToHomePage();
    } else {
      Assert.fail("There are no contacts to modify");
    }
    ;


  }
}
