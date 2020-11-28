package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testCreationContact() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Nicke", "B", "Marley", "tst@test.ru");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();

    before.add(contact);


    Comparator<? super ContactData> byName = (c1,c2)-> c2.getFirstname().equals(c1.getFirstname());
    before.sort(byName);
    after.sort(byName);
    Assert.assertEquals(before.size(), after.size());
    Assert.assertEquals(before, after);


  }
}
