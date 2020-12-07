package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test (enabled = false)
  public void testCreationContact() {
    app.goTo().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Nicke", "B", "Marley", "tst@test.ru");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    before.add(contact);

    Assert.assertEquals(before.size(), after.size());
    Comparator<? super ContactData> byName = (n1,n2) -> Integer.compare(n1.getId(),n2.getId());
    before.sort(byName);
    after.sort(byName);
    Assert.assertEquals(before, after);
  }
}
